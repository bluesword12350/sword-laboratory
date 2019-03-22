package reactor.core.publisher;

import org.junit.jupiter.api.Test;

/**
 * @author 李林峰
 */
class FluxTest {

    @Test
    void test(){
        Flux.just("Hello", "World").subscribe(System.out::println);
        System.out.println(1);
    }
}