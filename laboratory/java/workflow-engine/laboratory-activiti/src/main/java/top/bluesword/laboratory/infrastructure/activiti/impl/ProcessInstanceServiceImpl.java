package top.bluesword.laboratory.infrastructure.activiti.impl;

import java.util.List;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.bluesword.laboratory.infrastructure.activiti.ProcessInstanceService;

/**
 * 流程实例服务
 * @author 李林峰
 */
@Service
public class ProcessInstanceServiceImpl implements ProcessInstanceService {
	
	@Autowired RuntimeService runtimeService;
	
	@Override
	public String startByKey(String processDefinitionKey, Map<String, Object> variables) {
		return runtimeService
				.startProcessInstanceByKey(processDefinitionKey, variables)
				.getId();
	}
	
	@Override
	public void deleteByInstanceId(String processInstanceId, String deleteReason) {
		runtimeService.deleteProcessInstance(processInstanceId, deleteReason);
	}
	
	@Override
	public ProcessInstance queryByProcessInstanceId(String processInstanceId) {
		List<ProcessInstance> list = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId)
			.list();
		if (list.size()!=1) {
			return null;
		}
		return list.get(0);
	}
}
