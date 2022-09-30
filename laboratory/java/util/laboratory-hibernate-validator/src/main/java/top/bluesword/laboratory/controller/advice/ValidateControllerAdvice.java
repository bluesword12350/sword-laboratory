package top.bluesword.laboratory.controller.advice;

import org.springframework.beans.NotReadablePropertyException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.List;

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
    public List<ObjectError> validExceptionHandler(BindException e) {
        return e.getBindingResult().getAllErrors();
    }

    @ExceptionHandler(WebExchangeBindException.class)
    public List<ObjectError> exceptionHandler(WebExchangeBindException e) {
        return e.getBindingResult().getAllErrors();
    }

    @ExceptionHandler(NotReadablePropertyException.class)
    public String exceptionHandler(NotReadablePropertyException e) {
        return e.getLocalizedMessage();
    }

}
