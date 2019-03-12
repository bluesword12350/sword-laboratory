package top.bluesword.web.laboratory.infrastructure.activiti.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.bluesword.web.laboratory.infrastructure.activiti.TaskService;

/**
 * 任务服务
 * @author 李林峰
 */
@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	org.activiti.engine.TaskService taskService;

	@Override
	public List<Task> queryByCandidateGroup(String candidateGroup) {
		return taskService.createTaskQuery().taskCandidateGroup(candidateGroup).list();
	}
	
	@Override
	public List<Task> queryByAssignee(String assignee){
		return taskService.createTaskQuery().taskAssignee(assignee).list();
	}
	
	@Override
	public List<Task> queryByProcessInstanceId(String processInstanceId) {
		return taskService.createTaskQuery()
				.processInstanceId(processInstanceId).list();
	}
	
	@Override
	public void completeByProcessInstanceId(String processInstanceId, Map<String, Object> variables) {
		taskService.complete(queryByProcessInstanceId(processInstanceId).get(0).getId()
				, variables);
	}
	
	@Override
	public void completeByTaskId(String taskId, Map<String, Object> variables) {
		taskService.complete(taskId, variables);
	}
	
	@Override
	public void claim(String taskId, String userId) {
		taskService.claim(taskId, userId);
	}

	@Override
	public Task queryByTaskId(String taskId) {
		List<Task> list = taskService.createTaskQuery().taskId(taskId).list();
		if (list.size()!=1) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<IdentityLink> getIdentityLinksForTask(String taskId) {
		return taskService.getIdentityLinksForTask(taskId);
	}

	@Override
	public List<Task> queryTimeoutTask() {
		return taskService.createTaskQuery().taskDueBefore(new Date()).list();
	}

	@Override
	public void setDueDate(String taskId, Date dueDate) {
		taskService.setDueDate(taskId, dueDate);
	}
}
