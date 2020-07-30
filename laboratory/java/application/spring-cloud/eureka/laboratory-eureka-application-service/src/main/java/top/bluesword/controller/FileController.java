package top.bluesword.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.bluesword.feignclient.FileClient;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author 李林峰
 */
@RestController
@RequestMapping("file")
public class FileController {

    @Autowired
    private FileClient fileClient;

    @PostMapping
    public void map(MultipartFile file,String fileName,HttpServletResponse response) throws IOException {
        ResponseEntity<byte[]> map = fileClient.map(file, fileName);
        response.setHeader("content-disposition", "attachment;filename=" + fileName);
        try (ServletOutputStream outputStream = response.getOutputStream()){
            outputStream.write(Objects.requireNonNull(map.getBody()));
        }
    }

}
