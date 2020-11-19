package top.bluesword.maven.domain;

import org.junit.jupiter.api.Test;

class VersionTest {

    @Test
    void parse() {
        Version parse = Version.parse("3.0.0RC1");
        System.out.println(parse);
    }
}