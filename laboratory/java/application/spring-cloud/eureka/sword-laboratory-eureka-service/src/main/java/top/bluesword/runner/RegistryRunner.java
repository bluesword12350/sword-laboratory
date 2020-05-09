package top.bluesword.runner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author 李林峰
 */
@Component
public class RegistryRunner implements ApplicationRunner {

    final PeerAwareInstanceRegistry registry;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Autowired
    public RegistryRunner(PeerAwareInstanceRegistry registry) {
        this.registry = registry;
    }

    @Override
    public void run(ApplicationArguments args) throws IOException {
        InstanceInfo instanceInfo = buildInstanceInfo();
        registry.register(instanceInfo,false);
    }

    private InstanceInfo buildInstanceInfo() throws IOException {
        return MAPPER.readValue(readInstanceInfoJson(),InstanceInfo.class);
    }

    private String readInstanceInfoJson() throws IOException {
        InputStream io = getClass().getClassLoader().getResourceAsStream("InstanceInfo.json");
        assert io != null;
        return new String(io.readAllBytes(), StandardCharsets.UTF_8);
    }
}
