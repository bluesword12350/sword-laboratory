package top.bluesword.web.laboratory.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import top.bluesword.web.laboratory.async.AsyncTask;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author 李林峰
 */
@Controller
public class TestController {

    @Autowired
    AsyncTask asyncTask;

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @GetMapping(value={"/","home"})
    public void home(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + "/static.html");
    }

    @ResponseBody
    @PostMapping("requestTest")
    public Object requestTest(HttpServletRequest request, @RequestBody String body) {
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String element = headerNames.nextElement();
            log.info("{} : {}",element,request.getHeader(element));
        }
        log.info(body);
        return body;
    }

    @ResponseBody
    @GetMapping("async-task-start")
    public Object asyncTaskStart() throws InterruptedException {
        asyncTask.doTaskOne();
        log.info("异步任务开启，同步返回");
        return "开启完成";
    }
}