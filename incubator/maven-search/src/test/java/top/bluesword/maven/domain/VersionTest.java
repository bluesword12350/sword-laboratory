package top.bluesword.maven.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

class VersionTest {

    @Test
    void parse() {
        Version parse = Version.parse("3.0");
        System.out.println(parse);
    }

    @Test
    void compareTo() {
        List<String> list =
                List.of("3.0", "3.0-RC1", "3.0.0RC1", "3.0.0-RC3", "3.0.0-RC2", "3.0.1b", "4.2.0-RC1", "3.2.0b", "3.0.1", "3.0.2","3.0.0")
                        .stream()
                        .sorted(new VersionTextComparator().reversed())
                        .collect(Collectors.toList());
        System.out.println(list);
    }
}