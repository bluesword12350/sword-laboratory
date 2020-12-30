package top.bluesword.java.util;

import java.util.Timer;
import java.util.TimerTask;

class TaskTest {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new Task(timer), 3 * 1000, 1000);
    }
}

class Task extends TimerTask {
    private final Timer timer;

    public Task(Timer timer) {
        this.timer = timer;
    }

    int i = 1;

    @Override
    public void run() {
        System.out.println("******程序执行******");
        //当执行到第5秒，程序结束
        if (i++ == 5) {
            this.timer.cancel();
            System.out.println("******程序结束******");
        }
    }
}
