package top.bluesword.feignclient;

import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 李林峰
 */
@FeignClient(value = "sword-laboratory-eureka-base-service",path = "file",contextId = "file")
public interface FileClient {

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Response map(@RequestPart("file") MultipartFile file, @RequestParam  String fileName);

}
