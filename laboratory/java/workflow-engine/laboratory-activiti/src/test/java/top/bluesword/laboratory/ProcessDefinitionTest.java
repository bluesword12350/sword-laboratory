package top.bluesword.laboratory;

import lombok.extern.slf4j.Slf4j;
import org.activiti.bpmn.BpmnAutoLayout;
import org.activiti.bpmn.model.Process;
import org.activiti.bpmn.model.*;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.bluesword.laboratory.infrastructure.activiti.ProcessDefinitionService;

import java.io.IOException;
import java.util.*;

/**
 * 流程定义测试
 * 
 * @author 李林峰
 */
@Slf4j
@SpringBootTest
public class ProcessDefinitionTest {

	@Autowired RepositoryService repositoryService;
	@Autowired
    ProcessDefinitionService processDefinitionService;

	@Test
	public void main(){
		deploy();
		findProcessDefinition();
	}

	/**
	 * 部署流程定义
	 */
	@Test
	public void deploy() {
		String startEventId = "startEvent";
		String createTaskId = "createTask";
		String processingTaskId = "processingTask";
		String gatewayId = "gateway";
		String gateway2Id = "gateway2";
		String verifyTaskId = "verifyTask";

		Process process = new Process();
		process.setId("d");
		process.setName("任务流程");
		process.setExecutable(true);
		
		StartEvent startEvent = new StartEvent();
		startEvent.setId(startEventId);
		startEvent.setName("开始流程");
		process.addFlowElement(startEvent);
		
		UserTask createTask = new UserTask();
		createTask.setId(createTaskId);
		createTask.setName("创建任务");
		createTask.setAssignee("${createUser}");
		process.addFlowElement(createTask);

		process.addFlowElement(new SequenceFlow(startEventId,createTaskId));
		
		UserTask processingTask = new UserTask();
		processingTask.setId(processingTaskId);
		processingTask.setName("处理任务");
		List<String> candidateGroups = new ArrayList<>();
		candidateGroups.add("云乐");
		processingTask.setCandidateGroups(candidateGroups);
		
		process.addFlowElement(processingTask);

		process.addFlowElement(new SequenceFlow(createTaskId,processingTaskId));
		
		ExclusiveGateway gateway = new ExclusiveGateway();
		gateway.setId(gatewayId);
		gateway.setName("任务网关");
		process.addFlowElement(gateway);

		process.addFlowElement(new SequenceFlow(processingTaskId,gatewayId));
		
		SequenceFlow flow4 = new SequenceFlow(gatewayId,createTaskId);
		flow4.setConditionExpression("${!isItDone}");
		process.addFlowElement(flow4);

		UserTask verifyTask = new UserTask();
		verifyTask.setId(verifyTaskId);
		verifyTask.setName("核实任务");
		verifyTask.setAssignee("${createUser}");
		process.addFlowElement(verifyTask);

		SequenceFlow flow5 = new SequenceFlow(gatewayId,verifyTaskId);
		flow5.setConditionExpression("${isItDone}");
		process.addFlowElement(flow5);

		ExclusiveGateway gateway2 = new ExclusiveGateway();
		gateway2.setId(gateway2Id);
		gateway2.setName("任务网关2");
		process.addFlowElement(gateway2);

		process.addFlowElement(new SequenceFlow(verifyTaskId,gateway2Id));

		SequenceFlow flow7 = new SequenceFlow(gateway2Id,processingTaskId);
		flow7.setConditionExpression("${!isItDone}");
		process.addFlowElement(flow7);
		
		EndEvent endEvent = new EndEvent();
		endEvent.setId("endEvent");
		endEvent.setName("流程结束");
		process.addFlowElement(endEvent);

		SequenceFlow flow8 = new SequenceFlow(gateway2Id,"endEvent");
		flow8.setConditionExpression("${isItDone}");
		process.addFlowElement(flow8);

		BpmnModel bpmnModel = new BpmnModel();
		bpmnModel.setTargetNamespace("bluesword.top");
		bpmnModel.addProcess(process);
		
		new BpmnAutoLayout(bpmnModel).execute();
		
		Deployment deploy = repositoryService.createDeployment().addBpmnModel("bluesword.bpmn", bpmnModel).deploy();
		log.info("{}",deploy);
	}

	/**
	 * 查询流程定义
	 */
	@Test
	public void findProcessDefinition() {
		List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery()
				//.processDefinitionKey("e")
				//.deploymentId("27501")
				//.latestVersion()
				.list();
		List<Map<String, Object>> maps = new ArrayList<>();
		for (ProcessDefinition processDefinition : list) {
			Map<String, Object> map = new HashMap<>();
			map.put("流程定义ID:", processDefinition.getId());// 流程定义的key+版本+随机生成数
			map.put("流程定义名称:", processDefinition.getName());// 对应HelloWorld.bpmn文件中的name属性值
			map.put("流程定义的key:", processDefinition.getKey());// 对应HelloWorld.bpmn文件中的id属性值
			map.put("流程定义的版本:", processDefinition.getVersion());// 当流程定义的key值相同的情况下，版本升级，默认从1开始
			map.put("资源名称bpmn文件:", processDefinition.getResourceName());
			map.put("资源名称png文件:", processDefinition.getDiagramResourceName());
			map.put("部署对象ID:", processDefinition.getDeploymentId());
			maps.add(map);
		}
		log.info("{}",maps);
	}

	/**
	 * 删除流程定义
	 */
	@Test
	public void deleteProcessDefinition() {
		List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();
		//不带级联的删除 只能删除没有启动的流程，如果流程启动，就会抛出异常
		//repositoryService.deleteDeployment(deploymentId);
		//能级联的删除 能删除启动的流程，会删除和当前规则相关的所有信息，正在执行的信息，也包括历史信息
		//repositoryService.deleteDeployment(deploymentId,true)
		list.forEach(processDefinition -> 
				repositoryService.deleteDeployment(processDefinition.getDeploymentId(),true));
	}
	
	/**
	 * 查看流程图
	 */
	@Test
	public void findProcessPic() {
	    ProcessDefinition procDef = repositoryService.createProcessDefinitionQuery()
	    		.processDefinitionKey("d")
	            .singleResult();
		try {
			byte[] data = processDefinitionService.getResourceData(procDef);
			String encodeToString = Base64.getEncoder().encodeToString(data);
			System.out.println("data:image/png;base64,"+encodeToString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
