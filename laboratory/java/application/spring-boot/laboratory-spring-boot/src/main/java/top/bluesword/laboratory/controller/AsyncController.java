package top.bluesword.laboratory.controller;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.bluesword.laboratory.async.AsyncTask;

/**
 * @author 李林峰
 */
@RestController
@RequestMapping("async-task")
@AllArgsConstructor
public class AsyncController {

    private static final Logger log = LoggerFactory.getLogger(AsyncController.class);

    private AsyncTask asyncTask;

    @ResponseBody
    @GetMapping("start")
    public Object asyncTaskStart() throws InterruptedException {
        asyncTask.doTask();
        log.info("异步任务开启，同步返回");
        return "开启完成";
    }

}
