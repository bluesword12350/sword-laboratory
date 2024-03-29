package top.bluesword.laboratory.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李林峰
 */
@RestController
@RequestMapping("internationalization")
@AllArgsConstructor
public class InternationalizationController {

    private MessageSource messageSource;

    @GetMapping("hello")
    public String hello() {
        return messageSource.getMessage("demand.message.hello", null, LocaleContextHolder.getLocale());
    }

}
