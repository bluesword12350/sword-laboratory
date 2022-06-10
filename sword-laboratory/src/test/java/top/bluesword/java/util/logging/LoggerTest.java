package top.bluesword.java.util.logging;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

class LoggerTest {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Test
    void log() {
        logger.log(Level.OFF,"OFF");
        logger.log(Level.SEVERE,"SEVERE");
        logger.log(Level.WARNING,"WARNING");
        logger.log(Level.INFO,"INFO");
    }

    @Test
    void vsPrint(){
        int times = 100000;
        long printTime = print(times);
        long logTime = log(times);
        logger.info("print耗时："+printTime);
        logger.info("log耗时："+logTime);
    }

    private long log(int times) {
        Instant start = Instant.now();
        for (int i = 0; i < times; i++) {
            logger.info(String.valueOf(i));
        }
        Instant end = Instant.now();
        return Duration.between(start,end).getNano();
    }

    private long print(int times) {
        Instant start = Instant.now();
        for (int i = 0; i < times; i++) {
            System.out.println(i);
        }
        Instant end = Instant.now();
        return Duration.between(start,end).getNano();
    }
}
