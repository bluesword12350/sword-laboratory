package top.bluesword.laboratory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import top.bluesword.laboratory.domain.DataModel;
import top.bluesword.laboratory.service.QueryDslService;

import java.util.List;

/**
 * @author 李林峰
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("query-dsl/data")
public class QueryDslController {

	private final QueryDslService queryDslService;

	@GetMapping
	public List<DataModel> all() {
		return queryDslService.findAll();
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		queryDslService.delete(id);
	}

}
