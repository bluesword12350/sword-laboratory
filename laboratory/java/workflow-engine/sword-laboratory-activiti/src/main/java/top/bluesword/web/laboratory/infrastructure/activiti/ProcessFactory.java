package top.bluesword.web.laboratory.infrastructure.activiti;

import org.activiti.bpmn.BpmnAutoLayout;
import org.activiti.bpmn.model.Process;
import org.activiti.bpmn.model.*;
import top.bluesword.web.laboratory.infrastructure.activiti.exception.SwordActivityRuntimeException;

/**
 * 流程工厂
 * @author 李林峰
 */
public class ProcessFactory {

    private Process process;
    private String processId;
    private boolean alreadySetEndEvent = false;
    private boolean alreadySetStartEvent = false;
    private ProcessDefinitionService processDefinitionService;

    /**
     * 创建流程
     * @param processId 流程ID
     * @param processName 流程名称
     * @return 当前工厂
     */
    public static ProcessFactory createProcess(String processId, String processName){
        Process process = new Process();
        process.setId(processId);
        process.setName(processName);
        process.setExecutable(true);

        ProcessFactory processFactory = new ProcessFactory();
        processFactory.processId = processId;
        processFactory.process = process;
        return processFactory;
    }

    public ProcessFactory setProcessDefinitionService(ProcessDefinitionService processDefinitionService){
        this.processDefinitionService = processDefinitionService;
        return this;
    }

    public ProcessFactory setStartEvent(String startEventId,String startEventName){
        if (alreadySetStartEvent) throw new SwordActivityRuntimeException("已经设置开始节点");
        StartEvent startEvent = new StartEvent();
        startEvent.setId(startEventId);
        startEvent.setName(startEventName);
        process.addFlowElement(startEvent);
        alreadySetStartEvent = true;
        return this;
    }

    public ProcessFactory setEndEvent(String endEventId,String endEventName){
        if (alreadySetEndEvent) throw new SwordActivityRuntimeException("已经设置结束节点");
        EndEvent endEvent = new EndEvent();
        endEvent.setId(endEventId);
        endEvent.setName(endEventName);
        process.addFlowElement(endEvent);
        alreadySetEndEvent = true;
        return this;
    }

    public ProcessFactory addUserTask(String userTaskID, String userTaskName, String assignee){
        UserTask userTask = new UserTask();
        userTask.setId(userTaskID);
        userTask.setName(userTaskName);
        userTask.setAssignee(assignee);
        process.addFlowElement(userTask);
        return this;
    }

    public ProcessFactory addSequenceFlow(String sourceRef, String targetRef, String conditionExpression){
        SequenceFlow sequenceFlow = new SequenceFlow(sourceRef,targetRef);
        sequenceFlow.setConditionExpression(conditionExpression);
        process.addFlowElement(sequenceFlow);
        return this;
    }

    public ProcessFactory addExclusiveGateway(String gatewayId, String gatewayName){
        ExclusiveGateway gateway = new ExclusiveGateway();
        gateway.setId(gatewayId);
        gateway.setName(gatewayName);
        process.addFlowElement(gateway);
        return this;
    }

    public void createBpmnModelAndDeploy(String targetNamespace){
        BpmnModel bpmnModel = new BpmnModel();
        bpmnModel.setTargetNamespace(targetNamespace);
        bpmnModel.addProcess(process);
        new BpmnAutoLayout(bpmnModel).execute();
        processDefinitionService.deploy(processId, bpmnModel);
        this.process = null;
        this.processId = null;
        this.alreadySetEndEvent = false;
        this.alreadySetStartEvent = false;
    }
}
