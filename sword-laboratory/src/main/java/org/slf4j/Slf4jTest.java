package org.slf4j;

import org.junit.jupiter.api.Test;

class Slf4jTest {

    @Test
    void main() {
        Logger logger = LoggerFactory.getLogger(Slf4jTest.class);
        logger.info("{}{参数：{}，异常：{}}","日志：","a","无异常");
    }
}