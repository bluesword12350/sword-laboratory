package top.bluesword.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient("sword-laboratory-eureka-base-service")
public interface HomeClient {
    @RequestMapping("/map")
    Map<String,Object> map();
}
