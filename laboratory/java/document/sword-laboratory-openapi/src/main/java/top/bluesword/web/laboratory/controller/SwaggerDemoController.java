package top.bluesword.web.laboratory.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李林峰
 */
@RestController
@RequestMapping("SwaggerDemo")
@Tag(name = "Swagger测试")
public class SwaggerDemoController {

	@GetMapping("demo")
	@Operation(description = "最简测试")
	public String demo() {
		return "你好，Swagger";
	}
}
