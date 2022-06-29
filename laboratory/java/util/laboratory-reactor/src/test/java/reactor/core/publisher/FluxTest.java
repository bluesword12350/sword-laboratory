package reactor.core.publisher;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FluxTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Test
    void test(){
        Flux.range(0,100).subscribe(i -> log.info(i.toString()));
    }

}
