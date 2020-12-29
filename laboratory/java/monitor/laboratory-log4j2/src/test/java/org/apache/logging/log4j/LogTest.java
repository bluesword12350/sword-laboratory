package org.apache.logging.log4j;

import org.junit.jupiter.api.Test;

class LogTest {

    private static final Logger logger = LogManager.getLogger(LogTest.class);

    @Test
    void log() {
        logger.info("123");
    }
}
