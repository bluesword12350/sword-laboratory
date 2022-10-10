package top.bluesword.laboratory;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

/**
 * 任务处理测试
 * @author 李林峰
 */
@Slf4j
@SpringBootTest
public class TaskServiceTest {
	
	@Autowired TaskService taskService;
	
	/**
	 * 查询任务
	 */
	@Test
	public void taskQuery() {
		List<Task> list = taskService.createTaskQuery()
				//.processDefinitionKey("a")
				//.taskAssignee("龙仔")
				//.taskAssigneeIds(Collections.singletonList("龙仔"))
				//.taskCandidateGroup("云乐")
				//.taskCandidateGroupIn(Collections.singletonList("云乐"))
				//.processInstanceId("75001")
				//.processVariableValueLessThan("endTime", new Date())
				//.taskId("75007")
				//.taskDueBefore(new Date())//到期日在查询日期之前的
				.list();
		printTaskList(list);
	}
	
	/**
	 * 打印任务列表
	 */
	private void printTaskList(List<Task> list) {
		List<Map<String, Object>> maps = new ArrayList<>();
		for (Task task : list) {
			Map<String, Object> map = new HashMap<>();
			map.put("assignee", task.getAssignee());
			map.put("category", task.getCategory());
			map.put("createTime", task.getCreateTime());
			map.put("description", task.getDescription());
			map.put("dueDate", task.getDueDate());
			map.put("executionId", task.getExecutionId());
			map.put("formKey", task.getFormKey());
			map.put("id", task.getId());
			map.put("name", task.getName());
			map.put("owner", task.getOwner());
			map.put("parentTaskId", task.getParentTaskId());
			map.put("priority", task.getPriority());
			map.put("processInstanceId", task.getProcessInstanceId());
			map.put("processDefinitionId", task.getProcessDefinitionId());
			map.put("taskDefinitionKey", task.getTaskDefinitionKey());
			map.put("tenantId", task.getTenantId());
			map.put("ProcessVariables", task.getProcessVariables());
			map.put("TaskLocalVariables", task.getTaskLocalVariables());
			maps.add(map);
		}
		log.info("{}",maps);
	}
	
	/**
	 * 处理任务
	 */
	@Test
	public void completeTask() {
		Map<String, Object> variables = new HashMap<>();
		variables.put("isItDone", true);
		taskService.complete("7504", variables);
	}
	
	/**
	 * 拾取任务
	 */
	@Test
	public void claimTask() {
		taskService.claim("75007", "龙仔");
		taskService.setDueDate("75007", new Date());
		//userId 为空时 回退任务
		//taskService.claim(taskId, userId);
	}
	
}
