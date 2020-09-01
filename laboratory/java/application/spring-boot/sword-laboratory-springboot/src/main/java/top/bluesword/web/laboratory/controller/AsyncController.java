package top.bluesword.web.laboratory.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.bluesword.web.laboratory.async.AsyncTask;

/**
 * @author 李林峰
 */
@RestController
@RequestMapping("async-task")
public class AsyncController {

    private static final Logger log = LoggerFactory.getLogger(AsyncController.class);

    @Autowired
    AsyncTask asyncTask;

    @ResponseBody
    @GetMapping("start")
    public Object asyncTaskStart() throws InterruptedException {
        asyncTask.doTaskOne();
        log.info("异步任务开启，同步返回");
        return "开启完成";
    }

    @ResponseBody
    @GetMapping("start0")
    public Object asyncTaskStart0() throws InterruptedException {
        asyncTask.doTaskTwo();
        log.info("异步任务2开启，同步返回");
        return "开启完成";
    }
}
