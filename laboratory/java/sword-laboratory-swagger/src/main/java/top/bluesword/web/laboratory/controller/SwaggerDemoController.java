package top.bluesword.web.laboratory.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("SwaggerDemo")
@Api(tags = "Swagger测试")
public class SwaggerDemoController {
	private static final Logger log = LoggerFactory.getLogger(SwaggerDemoController.class);
	@GetMapping("demo")
	@ApiOperation("最简测试")
	public String demo() {
		return "你好，Swagger";
	}

	@PostMapping(value = "image")
	@ApiOperation("文件测试")
	public String image(@ApiParam(required = true) MultipartFile file, String filename, HttpServletResponse response) {
		if (file.isEmpty()) return "文件为空";
		String[] split = file.getOriginalFilename().split("\\.");
		long size = file.getSize();
		log.info("文件大小为"+(size/1024.0)+"KB");
		if (!split[split.length-1].equals("jpg")) {
			return "请选择JPG图片";
		}
		try (InputStream inputStream = file.getInputStream()) {
			byte[] data = new byte[inputStream.available()];
			inputStream.read(data);
			return "data:image/png;base64," + Base64.getEncoder().encodeToString(data);
		} catch (IOException e1) {
			return e1.toString();
		}
	}
}
