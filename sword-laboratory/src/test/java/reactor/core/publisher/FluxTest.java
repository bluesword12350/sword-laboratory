package reactor.core.publisher;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 李林峰
 */
class FluxTest {

    @Test
    void test(){
        Logger logger = LoggerFactory.getLogger(FluxTest.class);
        Flux.range(0,100).subscribe(i -> logger.info(i.toString()));
    }
}