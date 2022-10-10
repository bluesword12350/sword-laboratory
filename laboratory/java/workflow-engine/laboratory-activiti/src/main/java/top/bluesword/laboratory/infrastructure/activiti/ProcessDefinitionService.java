package top.bluesword.laboratory.infrastructure.activiti;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.repository.ProcessDefinition;

import java.io.IOException;

/**
 * 流程定义服务
 * @author 李林峰
 */
public interface ProcessDefinitionService {
	
	/**
	 * 部署流程定义
	 * @return 流程定义部署ID
	 */
	String deploy(String processId, BpmnModel bpmnModel);

	/**
	 * 通过流程定义ID获取流程图BASE64编码
	 */
	String getFlowChartBase64(String processId) throws IOException;

	byte[] getResourceData(ProcessDefinition procDef) throws IOException;

	/**
	 * 删除流程定义
	 * @param processId 流程定义ID
	 * @param cascade 是否级联删除，值为true时能删除启动的流程，会删除和当前规则相关的所有信息，正在执行的信息，也包括历史信息
	 */
	void delete(String processId, boolean cascade);

}
