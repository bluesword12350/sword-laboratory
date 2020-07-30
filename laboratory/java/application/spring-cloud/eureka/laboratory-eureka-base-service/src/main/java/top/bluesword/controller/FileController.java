package top.bluesword.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 李林峰
 */
@RestController
@RequestMapping("file")
public class FileController {

    @PostMapping
    public void map(MultipartFile file,String fileName,HttpServletResponse response) throws IOException {
        response.setHeader("content-disposition", "attachment;filename=" + fileName);
        try (ServletOutputStream outputStream = response.getOutputStream()){
            outputStream.write(file.getBytes());
        }
    }

}
