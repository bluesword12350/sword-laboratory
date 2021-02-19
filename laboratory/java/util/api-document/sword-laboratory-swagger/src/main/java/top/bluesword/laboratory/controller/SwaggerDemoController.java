package top.bluesword.laboratory.controller;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.bluesword.laboratory.transfer.BaseDataDTO;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Objects;

/**
 * @author 李林峰
 */
@RestController
@RequestMapping("SwaggerDemo")
@Api(tags = "Swagger测试")
public class SwaggerDemoController {

    private static final Logger log = LoggerFactory.getLogger(SwaggerDemoController.class);

	@GetMapping("demo")
	@ApiOperation("json出入参数")
	public BaseDataDTO body(@RequestBody BaseDataDTO data) {
		return data;
	}

    @PostMapping(value = "image")
    @ApiOperation("文件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "文件"),
            @ApiImplicitParam(name = "filename", value = "文件名称")
    })
    public String image(@ApiParam(required = true) MultipartFile file) {
        if (file.isEmpty()) {
            return "文件为空";
        }
        String[] split = Objects.requireNonNull(file.getOriginalFilename()).split("\\.");
        long size = file.getSize();
        log.info("文件大小为" + (size / 1024.0) + "KB");
        String jpgName = "jpg";
        if (!jpgName.equals(split[split.length - 1])) {
            return "请选择JPG图片";
        }
        try (InputStream inputStream = file.getInputStream()) {
            byte[] bytes = inputStream.readAllBytes();
            return "data:image/png;base64," + Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e1) {
            return e1.toString();
        }
    }
}
