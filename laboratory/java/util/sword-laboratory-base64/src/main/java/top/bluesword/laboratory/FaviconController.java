package top.bluesword.laboratory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

/**
 * @author 李林峰
 */
@Controller
@SpringBootApplication
public class FaviconController {

    public static void main(String[] args) {
        SpringApplication.run(FaviconController.class);
    }

    @GetMapping("favicon.ico")
    public void favicon(HttpServletResponse response) throws IOException {
        ServletOutputStream outputStream = response.getOutputStream();
        InputStream inputStream = FaviconController.class.getClassLoader().getResourceAsStream("rocket.base64");
        try (inputStream;outputStream) {
            assert inputStream != null;
            byte[] data = new byte[inputStream.available()];
            int read = inputStream.read(data);
            if (read<0) {
                return;
            }
            byte[] decode = Base64.getDecoder().decode(data);
            outputStream.write(decode);
        }
    }
}
