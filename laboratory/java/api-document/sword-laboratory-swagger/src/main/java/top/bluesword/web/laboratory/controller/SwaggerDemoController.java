package top.bluesword.web.laboratory.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Objects;

import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 李林峰
 */
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
	@ApiImplicitParams({
			@ApiImplicitParam(name = "file",value = "文件"),
			@ApiImplicitParam(name = "filename",value = "文件名称")
	})
	public String image(@ApiParam(required = true) MultipartFile file,  String filename, HttpServletResponse response) {
		if (file.isEmpty()) return "文件为空";
		String[] split = Objects.requireNonNull(file.getOriginalFilename()).split("\\.");
		long size = file.getSize();
		log.info("文件大小为"+(size/1024.0)+"KB");
		if (!"jpg".equals(split[split.length-1])) {
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
