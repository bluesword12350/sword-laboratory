package top.bluesword.java.util.function;

/**
 * @author 李林峰
 */
@FunctionalInterface
public interface SchedulingTask {

    /**
     * 执行任务
     */
    void execute();
}
