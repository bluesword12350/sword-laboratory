package top.bluesword.laboratory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author 李林峰
 */
@Controller
public class TestController {
    @GetMapping(value={"/","home"})
    public void home(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + "/static.html");
    }

    @ResponseBody
    @PostMapping("requestTest")
    public Object requestTest(HttpServletRequest request, @RequestBody String body) {
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String element = headerNames.nextElement();
            System.out.println(element+":"+request.getHeader(element));
        }
        System.out.println(body);
        return body;
    }
}