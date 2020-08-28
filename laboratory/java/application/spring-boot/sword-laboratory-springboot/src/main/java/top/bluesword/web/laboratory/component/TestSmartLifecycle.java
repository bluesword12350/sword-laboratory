package top.bluesword.web.laboratory.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * SmartLifecycle测试
 * @author 李林峰
 */
@Component
public class TestSmartLifecycle implements SmartLifecycle {

    private static final Logger log = LoggerFactory.getLogger(TestSmartLifecycle.class);

    private boolean isRunning = false;

    @Override
    public void start() {
        log.info("start");
        isRunning = true;
    }

    @Override
    public void stop() {
        log.info("stop");
        isRunning = false;
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable callback) {
        System.out.println("stop(Runnable)");
        callback.run();
        isRunning = false;
    }

    @Override
    public int getPhase() {
        return 0;
    }
}
