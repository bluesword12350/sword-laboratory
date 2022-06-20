package top.bluesword.enums;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class CurrencyCodeEnumTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    void test(){
        logger.info(CurrencyCodeEnum.valueOf("CNY").toString());
    }

}