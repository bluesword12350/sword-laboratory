package top.bluesword.java.util.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

class StreamTest {

    @Test
    void of(){
        System.out.println(Stream.of("1", "2", "3"));
    }

    @Test
    void stream(){
        System.out.println(List.of("1", "2", "3").stream());
    }

    @Test
    void forEach(){
        Stream.of("1", "2", "3").forEach(System.out::print);
    }

    @Test
    void filter(){
        Stream.of("1", "2", "3").filter("1"::equals).forEach(System.out::print);
    }

}
