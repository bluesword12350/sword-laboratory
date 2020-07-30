package top.bluesword.web.laboratory.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ZeroCopyHttpOutputMessage;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.io.File;

/**
 * @author 李林峰
 */
@RestController
@RequestMapping("webflux-file")
public class WebfluxFileController {

    @GetMapping("download")
    public Mono<Void> get(ServerHttpResponse response) {
        return outToHttp(response);
    }

    private Mono<Void> outToHttp(ServerHttpResponse response) {
        ZeroCopyHttpOutputMessage zeroCopyResponse = (ZeroCopyHttpOutputMessage) response;
        response.getHeaders().set(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=pom.xml");
        response.getHeaders().setContentType(MediaType.APPLICATION_OCTET_STREAM);
        File file = new File("pom.xml");
        return zeroCopyResponse.writeWith(file, 0, file.length());
    }

}
