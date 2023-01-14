package top.bluesword.laboratory.util;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

/**
 * 从 org.springframework.boot.validation.MessageSourceMessageInterpolator 复制部分代码
 * @author 李林峰
 */
@Component
@RequiredArgsConstructor
public final class MessageSourceExpansion {

    private static final char PREFIX = '{';
    private static final char SUFFIX = '}';
    private static final char ESCAPE = '\\';

    private final MessageSource messageSource;

    public String getMessage(String message) {
        return getMessage(message,LocaleContextHolder.getLocale());
    }

    public String getMessage(String message, Locale locale) {
        return replaceParameters(message, NullArgsProvider.INSTANCE, locale, new LinkedHashSet<>(4));
    }

    public String getMessageWithSingleArgs(String message,Object[] args) {
        return getMessageWithSingleArgs(message,args,LocaleContextHolder.getLocale());
    }

    public String getMessageWithSingleArgs(String message,Object[] args, Locale locale) {
        return replaceParameters(message,SingleArgsProvider.of(args), locale, new LinkedHashSet<>(4));
    }

    private String replaceParameters(String message,ArgsProvider argsProvider, Locale locale, Set<String> visitedParameters) {
        StringBuilder buf = new StringBuilder(message);
        int parentheses = 0;
        int startIndex = -1;
        int endIndex = -1;
        for (int i = 0; i < buf.length(); i++) {
            if (buf.charAt(i) == ESCAPE) {
                i++;
            }
            else if (buf.charAt(i) == PREFIX) {
                if (startIndex == -1) {
                    startIndex = i;
                }
                parentheses++;
            }
            else if (buf.charAt(i) == SUFFIX) {
                if (parentheses > 0) {
                    parentheses--;
                }
                endIndex = i;
            }
            if (parentheses == 0 && startIndex < endIndex) {
                String parameter = buf.substring(startIndex + 1, endIndex);
                if (!visitedParameters.add(parameter)) {
                    throw new IllegalArgumentException(
                            "Circular reference '{" + String.join(" -> ", visitedParameters) + " -> " + parameter + "}'"
                    );
                }
                String value = replaceParameter(parameter,argsProvider, locale, visitedParameters);
                if (value != null) {
                    buf.replace(startIndex, endIndex + 1, value);
                    i = startIndex + value.length() - 1;
                }
                visitedParameters.remove(parameter);
                startIndex = -1;
                endIndex = -1;
            }
        }
        return buf.toString();
    }

    private String replaceParameter(String parameter,ArgsProvider argsProvider, Locale locale, Set<String> visitedParameters) {
        parameter = replaceParameters(parameter,argsProvider, locale, visitedParameters);
        String value = this.messageSource.getMessage(parameter, argsProvider.getArgs(), locale);
        return isUsingCodeAsDefaultMessage(value, parameter) ? null : replaceParameters(value, argsProvider, locale, visitedParameters);
    }

    private boolean isUsingCodeAsDefaultMessage(String value, String parameter) {
        return value.equals(parameter);
    }

    interface ArgsProvider {
        /**
         * 获取参数
         * @return 参数
         */
        Object[] getArgs();
    }

    enum NullArgsProvider implements ArgsProvider{
        /**
         * 单例
         */
        INSTANCE;

        @Override
        public Object[] getArgs() {
            return null;
        }

    }

    static class SingleArgsProvider implements ArgsProvider{

        private final Object[] args;

        private SingleArgsProvider(Object[] args) {
            this.args = args;
        }

        public static SingleArgsProvider of(Object[] args){
            return new SingleArgsProvider(args);
        }

        @Override
        public Object[] getArgs() {
            return args;
        }
    }

}
