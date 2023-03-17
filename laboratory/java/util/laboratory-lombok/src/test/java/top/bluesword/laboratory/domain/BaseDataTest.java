package top.bluesword.laboratory.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Instant;

@Slf4j
class BaseDataTest {

    @Test
    void testEquals() {
        Instant now = Instant.now();
        BaseData baseData0 = new BaseData(1L,now);
        BaseData baseData1 = new BaseData(1L,now);
        BaseData baseData2 = new BaseData(1L,null);
        BaseData baseData3 = new BaseData(1L,null);
        log.info("baseData0.equals(baseData1):{}",baseData0.equals(baseData1));
        log.info("baseData0.equals(baseData2):{}",baseData0.equals(baseData2));
        log.info("baseData2.equals(baseData3):{}",baseData2.equals(baseData3));
    }
}