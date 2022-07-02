package top.bluesword.laboratory.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

/**
 * @author 李林峰
 */
@Controller
public class HelloController {

    @Get
    public String index() {
        return "Hello World";
    }

}
