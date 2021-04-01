package top.bluesword.runner;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.resolver.DefaultEndpoint;
import com.netflix.discovery.shared.transport.EurekaHttpClient;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.cloud.netflix.eureka.http.RestTemplateTransportClientFactory;
import org.springframework.stereotype.Component;
import top.bluesword.util.EurekaUtil;

import java.io.IOException;

/**
 * @author 李林峰
 */
@Component
public class RegistryRunner implements ApplicationRunner {

    private final PeerAwareInstanceRegistry registry;
    private final EurekaHttpClient eurekaHttpClient;

    @Autowired
    public RegistryRunner(PeerAwareInstanceRegistry registry,EurekaClientConfigBean eurekaClientConfigBean) {
        this.registry = registry;
        RestTemplateTransportClientFactory clientFactory = new RestTemplateTransportClientFactory();
        String serviceUrl = eurekaClientConfigBean.getServiceUrl().get(EurekaClientConfigBean.DEFAULT_ZONE);
        this.eurekaHttpClient = clientFactory.newClient(new DefaultEndpoint(serviceUrl));
    }

    @Override
    public void run(ApplicationArguments args) throws IOException {
        //todo 尝试精简 json
        registry.register(EurekaUtil.buildInstanceInfo("LOONG-SWORD-1.json"),false);
        eurekaHttpClient.register(EurekaUtil.buildInstanceInfo("LOONG-SWORD-2.json"));

        for (Application registeredApplication : eurekaHttpClient.getApplications().getEntity().getRegisteredApplications()) {
            for (InstanceInfo instance : registeredApplication.getInstances()) {
                registry.register(instance, false);
            }
        }
    }

}
