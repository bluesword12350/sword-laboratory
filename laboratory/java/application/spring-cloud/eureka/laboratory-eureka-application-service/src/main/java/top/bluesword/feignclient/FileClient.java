package top.bluesword.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author 李林峰
 */
@FeignClient(value = "sword-laboratory-eureka-base-service",path = "file",contextId = "file")
public interface FileClient {

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<byte[]> map(@RequestParam MultipartFile file,@RequestParam  String fileName);

}
