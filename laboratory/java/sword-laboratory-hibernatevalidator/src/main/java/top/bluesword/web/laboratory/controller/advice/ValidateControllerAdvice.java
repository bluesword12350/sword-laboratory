package top.bluesword.web.laboratory.controller.advice;

import java.util.List;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
        StringBuilder sbuild = new StringBuilder();
        fieldErrors.forEach(f -> sbuild.append("[")
        		.append(f.getDefaultMessage()).append("]"));
		return sbuild.toString();
    }
}
