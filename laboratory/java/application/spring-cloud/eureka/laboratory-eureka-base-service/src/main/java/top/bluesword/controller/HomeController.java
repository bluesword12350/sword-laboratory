package top.bluesword.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 李林峰
 */
@RestController
public class HomeController {

    @RequestMapping("/map")
    public Map<String,Object> map() {
        Map<String,Object> map = new HashMap<>();
        map.put("author","李林峰");
        return map;
    }

}
