package top.bluesword.laboratory.infrastructure.activiti.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.bluesword.laboratory.infrastructure.activiti.ProcessDefinitionService;

/**
 * 流程定义服务
 * @author 李林峰
 */
@Service
public class ProcessDefinitionServiceImpl implements ProcessDefinitionService {
	
	@Autowired RepositoryService repositoryService;

	@Override
	public String deploy(String processId,BpmnModel bpmnModel) {
		return repositoryService.createDeployment()
				.addBpmnModel(processId+".bpmn", bpmnModel)
				.deploy().getId();
	}
	
	@Override
	public String getFlowChartBase64(String processId) throws IOException {
		return Base64.getEncoder().encodeToString(
				getResourceData(repositoryService.createProcessDefinitionQuery()
									.processDefinitionKey(processId).singleResult()));
	}

	@Override
	public byte[] getResourceData(ProcessDefinition procDef) throws IOException {
		String diagramResourceName = procDef.getDiagramResourceName();
		byte[] data;
		try (InputStream imageStream = repositoryService.getResourceAsStream(
				procDef.getDeploymentId(), diagramResourceName)){
			data = new byte[imageStream.available()];
			imageStream.read(data);
			return data;
		}
	}
	
	@Override
	public void delete(String processId, boolean cascade) {
		List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery()
				.processDefinitionKey(processId)
				.list();
		list.forEach(processDefinition -> 
				repositoryService.deleteDeployment(processDefinition.getDeploymentId(),cascade));
	}

}
