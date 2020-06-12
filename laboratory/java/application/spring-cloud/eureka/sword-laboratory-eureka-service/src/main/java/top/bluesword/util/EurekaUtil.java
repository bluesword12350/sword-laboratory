package top.bluesword.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.appinfo.InstanceInfo;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author 李林峰
 */
public final class EurekaUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static InstanceInfo buildInstanceInfo(String name) throws IOException {
        return MAPPER.readValue(readInstanceInfoJson(name),InstanceInfo.class);
    }

    private static String readInstanceInfoJson(String name) throws IOException {
        InputStream io = EurekaUtil.class.getClassLoader().getResourceAsStream("application/"+name);
        assert io != null;
        return new String(io.readAllBytes(), StandardCharsets.UTF_8);
    }

}
