package top.bluesword.web.laboratory;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 流程实例测试
 * @author 李林峰
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProcessInstanceTest {
	
	@Autowired RuntimeService runtimeService;
	
	/**
	 * 启动一个流程
	 */
	@Test
	public void startProcessInstanceById() {
		Map<String, Object> variables = new HashMap<>();
		variables.put("createUser", "龙仔");
		String id = runtimeService
				//.startProcessInstanceByKey("a")
				.startProcessInstanceByKey("d", variables)
				.getId();
		System.out.println(id);
	}
	
	/**
	 * 删除流程实例
	 */
	@Test
	public void deleteProcessInstance() {
		runtimeService.deleteProcessInstance("7501", "测试删除");
	}
}