package top.bluesword.java.util.function;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SchedulingTaskTest {

    @Test
    void execute() {
        toPrint(this::print);
    }

    void print(){
        System.out.println("任务执行");
    }

    void toPrint(SchedulingTask schedulingTask){
        schedulingTask.execute();
    }
}