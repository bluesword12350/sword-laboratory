package top.bluesword.java.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * 并发编程实例
 * @author 李林峰
 */
public class ForkJoinExample extends RecursiveTask<Integer> {
    
    private static final int THRESHOLD = 2;
    private int start;
    private int end;

    private ForkJoinExample(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;

        if ((end - start) <= THRESHOLD) {
            //如果任务足够小就计算任务
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            // 如果任务大于阈值，就分裂成两个子任务计算
            int middle = (start + end) / 2;
            ForkJoinExample leftTask = new ForkJoinExample(start, middle);
            ForkJoinExample rightTask = new ForkJoinExample(middle + 1, end);

            // 执行子任务
            leftTask.fork();
            rightTask.fork();

            //等待任务执行结束合并其结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            //合并子任务
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkjoinPool = new ForkJoinPool();
        ForkJoinExample task = new ForkJoinExample(1, 100);
        Future<Integer> result = forkjoinPool.submit(task);
        System.out.println(result.get());
    }
}