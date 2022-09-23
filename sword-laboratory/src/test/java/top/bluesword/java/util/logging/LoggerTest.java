package top.bluesword.java.util.logging;

import org.junit.jupiter.api.Test;

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

}
