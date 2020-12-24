package org.springframework.util;

import org.junit.jupiter.api.Test;

class AntPathMatcherTest {

    @Test
    void test() {
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        boolean match = antPathMatcher.match("/a/**", "/a/1");
        System.out.println(match);
        boolean match2 = antPathMatcher.match("/a/**/b", "/a/1");
        System.out.println(match2);
        boolean match3 = antPathMatcher.match("/a/**/b", "/a/1/b");
        System.out.println(match3);
    }

}
