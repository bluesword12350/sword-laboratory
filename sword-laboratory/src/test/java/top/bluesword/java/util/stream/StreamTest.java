package top.bluesword.java.util.stream;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

class StreamTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Test
    void of(){
        log.info("{}",Stream.of("1", "2", "3"));
    }

    @Test
    void forEach(){
        Stream.of("1", "2", "3").forEach(log::info);
    }

    @Test
    void filter(){
        Stream.of("1", "2", "3").filter("1"::equals).forEach(log::info);
    }

}
