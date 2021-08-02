package top.bluesword.laboratory.controller.advice;

import org.springframework.beans.NotReadablePropertyException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

/**
 * @author 李林峰
 */
@RestControllerAdvice
public class ValidateControllerAdvice {

    /**
     * bean校验未通过异常
     *
     * @see javax.validation.Valid
     * @see org.springframework.validation.Validator
     * @see org.springframework.validation.DataBinder
     */
    @ExceptionHandler(BindException.class)
    public String validExceptionHandler(BindException e) {
        return toMessage(e.getBindingResult());
    }

    private String toMessage(BindingResult bindingResult) {
        StringBuilder build = new StringBuilder().append("[");
        for (FieldError f : bindingResult.getFieldErrors()) {
            build.append(f.getField()).append(':').append(f.getDefaultMessage()).append(';');
        }
        for (ObjectError g : bindingResult.getGlobalErrors()) {
            build.append(g.getDefaultMessage()).append(';');
        }
        build.setCharAt(build.length()-1,']');
        return build.toString();
    }

    @ExceptionHandler(WebExchangeBindException.class)
    public String exceptionHandler(WebExchangeBindException e) {
        return toMessage(e.getBindingResult());
    }

    @ExceptionHandler(NotReadablePropertyException.class)
    public String exceptionHandler(NotReadablePropertyException e) {
        return e.getLocalizedMessage();
    }
}
