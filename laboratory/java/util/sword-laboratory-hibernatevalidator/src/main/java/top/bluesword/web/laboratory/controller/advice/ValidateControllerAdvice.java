package top.bluesword.web.laboratory.controller.advice;

import java.util.List;

import org.springframework.beans.NotReadablePropertyException;
import org.springframework.validation.BindException;
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
        List<FieldError> fieldErrors=e.getBindingResult().getFieldErrors();
        StringBuilder build = new StringBuilder();
        fieldErrors.forEach(f -> build.append("[").append(f.getField())
        		.append(f.getDefaultMessage()).append("]"));
		return build.toString();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String exceptionHandler(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors=e.getBindingResult().getFieldErrors();
        StringBuilder build = new StringBuilder();
        fieldErrors.forEach(f -> build.append("[").append(f.getField())
                .append(f.getDefaultMessage()).append("]"));
        return build.toString();
    }

    @ExceptionHandler(NotReadablePropertyException.class)
    public String exceptionHandler(NotReadablePropertyException e) {
        e.printStackTrace();
        return e.getLocalizedMessage();
    }
}
