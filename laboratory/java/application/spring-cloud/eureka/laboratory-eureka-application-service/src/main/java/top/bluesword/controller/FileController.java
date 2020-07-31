package top.bluesword.controller;

import feign.Response;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.bluesword.feignclient.FileClient;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

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
        Response map = fileClient.map(file, fileName);
        response.setHeader("content-disposition", "attachment;filename=" + fileName);
        InputStream inputStream = map.body().asInputStream();
        try (ServletOutputStream outputStream = response.getOutputStream();inputStream){
            IOUtils.copy(inputStream,outputStream);
        }
    }

}
