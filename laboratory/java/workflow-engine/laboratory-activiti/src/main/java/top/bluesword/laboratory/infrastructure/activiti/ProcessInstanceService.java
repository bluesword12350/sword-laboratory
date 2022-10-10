package top.bluesword.laboratory.infrastructure.activiti;

import java.util.Map;

import org.activiti.engine.runtime.ProcessInstance;

/**
 * 流程实例服务
 * @author 李林峰
 */
public interface ProcessInstanceService {


	/**
	 * 启动流程
	 * @param processDefinitionKey 流程定义key
	 * @param variables 变量
	 * @return 流程实例id
	 */
	String startByKey(String processDefinitionKey, Map<String, Object> variables);

	/**
	 * 通过流程实例ID删除流程实例
	 * @param processInstanceId 流程实例ID
	 * @param deleteReason 删除理由
	 */
	void deleteByInstanceId(String processInstanceId, String deleteReason);

	/**
	 * 通过流程实例ID查询流程实例
	 * @param processInstanceId 流程实例ID
	 * @return 流程实例
	 */
	ProcessInstance queryByProcessInstanceId(String processInstanceId);

}
