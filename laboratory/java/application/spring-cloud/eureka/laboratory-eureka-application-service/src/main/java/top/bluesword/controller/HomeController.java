package top.bluesword.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.bluesword.feignclient.HomeClient;

import java.util.Map;

@RestController
public class HomeController {

    @Autowired
    HomeClient homeClient;

    @RequestMapping("/map")
    public Map<String,Object> map() {
        return homeClient.map();
    }

}
