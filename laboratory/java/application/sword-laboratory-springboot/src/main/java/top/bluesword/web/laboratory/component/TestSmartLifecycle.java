package top.bluesword.web.laboratory.component;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * SmartLifecycle测试
 * @author 李林峰
 */
@Component
public class TestSmartLifecycle implements SmartLifecycle {

    private boolean isRunning = false;

    @Override
    public void start() {
        System.out.println("start");
        isRunning = true;
    }

    @Override
    public void stop() {
        System.out.println("stop");
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
