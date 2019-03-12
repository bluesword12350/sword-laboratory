package com.baidu.aip.contentcensor;

import org.junit.jupiter.api.Test;

class AipContentCensorUtilTest {

    @Test
    void antiSpam() {
        System.out.println(AipContentCensorUtil.antiSpam("雄安孙一峰").toString());
    }
}