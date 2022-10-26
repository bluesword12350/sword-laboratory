package top.bluesword.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author 李林峰
 */
@RestController
public class BusinessController {

    @GetMapping("page")
    public ModelAndView test() {
        return new ModelAndView("page");
    }

    @PostMapping("save")
    void save(@RequestBody String body) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(UUID.randomUUID().toString());
        try(fileOutputStream) {
            fileOutputStream.write(body.getBytes());
        }
    }

}
