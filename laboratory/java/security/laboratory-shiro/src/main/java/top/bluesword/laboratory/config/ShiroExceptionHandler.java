package top.bluesword.laboratory.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 李林峰
 */
@ControllerAdvice
@Slf4j
public class ShiroExceptionHandler {

    @ExceptionHandler({UnauthorizedException.class})
    @ResponseBody
    public String errorHandler(UnauthorizedException e) {
        log.error("没有通过权限验证:{}",e.getMessage());
        return "没有通过权限验证！";
    }

}
