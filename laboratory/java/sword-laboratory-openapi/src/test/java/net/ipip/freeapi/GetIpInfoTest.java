package net.ipip.freeapi;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GetIpInfoTest {

    @Test
    void getIpInfo() {
        Map<String, String> ipInfo = GetIpInfo.getIpInfo("180.97.33.107");
        System.out.println(JSON.toJSONString(ipInfo));
    }
}