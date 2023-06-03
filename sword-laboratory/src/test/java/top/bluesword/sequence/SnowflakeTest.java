package top.bluesword.sequence;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SnowflakeTest {

    private static final Logger LOG = Logger.getLogger(SnowflakeTest.class.getName());

    @Test
    void baseTest(){
        Snowflake snowflake = new Snowflake();
        for (int i = 0; i < 100; i++) {
            System.out.print(snowflake.nextId());
            System.out.print(",");
        }
    }

    @Test
    void tpsTest(){
        Snowflake snowflake = new Snowflake(24,0,0,
                0,0,1000);
        long start = System.currentTimeMillis()/1000;
        long reStart;
        do {
            reStart = System.currentTimeMillis()/1000;
        }while (reStart==start);
        int num = 0;
        while (System.currentTimeMillis()/1000==reStart){
            snowflake.nextId();
            num++;
        }
        System.out.println(num);
    }

    @Test
    void parse() {
        Random random = new Random();
        int dataCenterId = random.nextInt(10);
        LOG.info("dataCenterId:"+dataCenterId);
        int workerId = random.nextInt(10);
        LOG.info("workerId:"+workerId);
        int sequenceBits = 1+random.nextInt(10);
        LOG.info("sequenceBits:"+sequenceBits);
        int dataCenterIdBits = 5+random.nextInt(10);
        LOG.info("dataCenterIdBits:"+dataCenterIdBits);
        int workerIdBits = 5+random.nextInt(10);
        LOG.info("workerIdBits:"+workerIdBits);
        Snowflake snowflake = new Snowflake(sequenceBits,dataCenterIdBits,workerIdBits,dataCenterId,workerId,1000);
        long snowflakeId = snowflake.nextId();
        LOG.info("snowflakeId:"+snowflakeId);
        Snowflake.SnowflakeData snowflakeData = snowflake.parse(snowflakeId);
        LOG.info("snowflakeData:"+snowflakeData);
        assertEquals(dataCenterId,snowflakeData.getDataCenterId());
        assertEquals(workerId,snowflakeData.getWorkerId());
        ZonedDateTime timestamp = snowflakeData.getTimestamp();
        LOG.info("timestamp:"+timestamp);
        ZonedDateTime now = ZonedDateTime.now();
        Duration between = Duration.between(timestamp, now);
        LOG.info("now:"+now);
        assertTrue(between.compareTo(Duration.of(2, ChronoUnit.SECONDS))<0);
    }

    @Test
    void parse0() {
        int dataCenterId = 2;
        int workerId = 3;
        int sequenceBits = 10;
        int dataCenterIdBits = 13;
        int workerIdBits = 14;
        Snowflake snowflake = new Snowflake(sequenceBits,dataCenterIdBits,workerIdBits,dataCenterId,workerId,1000);
        long snowflakeId = snowflake.nextId();
        Snowflake.SnowflakeData snowflakeData = snowflake.parse(snowflakeId);
        assertEquals(dataCenterId,snowflakeData.getDataCenterId());
        assertEquals(workerId,snowflakeData.getWorkerId());
        ZonedDateTime timestamp = snowflakeData.getTimestamp();
        LOG.info("timestamp:"+timestamp);
        ZonedDateTime now = ZonedDateTime.now();
        Duration between = Duration.between(timestamp, now);
        assertTrue(between.compareTo(Duration.of(2, ChronoUnit.SECONDS))<0);
    }

}