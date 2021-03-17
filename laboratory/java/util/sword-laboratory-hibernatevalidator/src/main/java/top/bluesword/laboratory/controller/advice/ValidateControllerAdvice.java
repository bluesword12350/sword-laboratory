package top.bluesword.laboratory.controller.advice;

import java.util.List;

import org.springframework.beans.NotReadablePropertyException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
        List<FieldError> fieldErrors= bindingResult.getFieldErrors();
        StringBuilder build = new StringBuilder().append("[");
        for (FieldError f : fieldErrors) {
            build.append(f.getField()).append(':').append(f.getDefaultMessage()).append(',');
        }
        build.setCharAt(build.length()-1,']');
        return build.toString();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String exceptionHandler(MethodArgumentNotValidException e) {
        return toMessage(e.getBindingResult());
    }

    @ExceptionHandler(NotReadablePropertyException.class)
    public String exceptionHandler(NotReadablePropertyException e) {
        e.printStackTrace();
        return e.getLocalizedMessage();
    }
}
