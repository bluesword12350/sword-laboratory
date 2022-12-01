package top.bluesword.laboratory.util;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
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

    public String getMessage(String message, Locale locale) {
        return replaceParameters(message, locale, new LinkedHashSet<>(4));
    }

    private String replaceParameters(String message, Locale locale, Set<String> visitedParameters) {
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
                    throw new IllegalArgumentException("Circular reference '{" + String.join(" -> ", visitedParameters)
                            + " -> " + parameter + "}'");
                }
                String value = replaceParameter(parameter, locale, visitedParameters);
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

    private String replaceParameter(String parameter, Locale locale, Set<String> visitedParameters) {
        parameter = replaceParameters(parameter, locale, visitedParameters);
        String value = this.messageSource.getMessage(parameter, null, null, locale);
        return (value != null && !isUsingCodeAsDefaultMessage(value, parameter))
                ? replaceParameters(value, locale, visitedParameters) : null;
    }

    private boolean isUsingCodeAsDefaultMessage(String value, String parameter) {
        return value.equals(parameter);
    }

}
