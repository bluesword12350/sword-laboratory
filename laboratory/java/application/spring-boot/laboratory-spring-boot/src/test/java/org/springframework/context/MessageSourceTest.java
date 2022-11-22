package org.springframework.context;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.nio.charset.StandardCharsets;

@Slf4j
class MessageSourceTest {

    private final MessageSource messageSource;

    public MessageSourceTest() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
        messageSource.setBasename("demand-message");
        messageSource.setBeanClassLoader(this.getClass().getClassLoader());
        this.messageSource = messageSource;
    }

    @Test
    void base(){
        String message = messageSource.getMessage("demand.message.hello", null, LocaleContextHolder.getLocale());
        log.info("base:{}",message);
    }

    @Test
    void args(){
        String message = messageSource.getMessage("demand.message.args", new Object[]{"123"}, LocaleContextHolder.getLocale());
        log.info("args:{}",message);
    }

}
