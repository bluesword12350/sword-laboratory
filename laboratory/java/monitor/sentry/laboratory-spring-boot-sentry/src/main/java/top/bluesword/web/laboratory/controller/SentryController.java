package top.bluesword.web.laboratory.controller;

import io.sentry.Sentry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 李林峰
 */
@Controller
public class SentryController {

    private static Logger logger = LoggerFactory.getLogger(SentryController.class);

    @RequestMapping("/")
    @ResponseBody
    String home() throws Exception {
        Sentry.capture("sentry message--llf in Controller by Sentry.capture");
        throw new Exception("sentry error--llf in Controller by new Exception");
    }

}
