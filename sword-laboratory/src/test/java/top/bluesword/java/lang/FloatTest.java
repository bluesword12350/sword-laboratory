package top.bluesword.java.lang;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * @author 李林峰
 */
class FloatTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Test
    void toBinaryString(){
        float value = new Random().nextFloat();
        String binaryString = Long.toBinaryString(Float.floatToIntBits(value));
        binaryString = String.format("%0"+(32-binaryString.length())+"d%s",0,binaryString);
        log.info("{}",value);
        log.info(binaryString);
        log.info("============sign============");
        log.info("{}",binaryString.charAt(0));
        log.info("============biased exponent============");
        log.info(binaryString.substring(1, 9));
        log.info("============fraction============");
        log.info(binaryString.substring(9));
    }

}
