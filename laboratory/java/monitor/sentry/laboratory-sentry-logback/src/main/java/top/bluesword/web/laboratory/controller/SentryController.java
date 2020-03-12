package top.bluesword.web.laboratory.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 李林峰
 */
@Controller
public class SentryController {

    private static Logger logger = LoggerFactory.getLogger(SentryController.class);

    @RequestMapping("/")
    @ResponseBody
    public void home(String message) {
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS ZZ").format(new Date());
        logger.warn("{} {} by logger.warn",date,message,new RuntimeException("warn runtime exception"));
        logger.error("{} {} by logger.error",date,message,new Exception("error exception"));
    }

}
