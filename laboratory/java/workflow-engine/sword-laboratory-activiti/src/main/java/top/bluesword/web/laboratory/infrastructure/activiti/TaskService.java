package top.bluesword.web.laboratory.infrastructure.activiti;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task;

/**
 * 任务服务
 * @author 李林峰
 */
public interface TaskService {

	/**
	 * 通过组名查询任务
	 * @param candidateGroup 组名
	 * @return 流程实例ID列表
	 */
	List<Task> queryByCandidateGroup(String candidateGroup);
	
	/**
	 * 通过任务执行人查询任务
	 * @param assignee 执行人
	 * @return 流程实例ID列表
	 */
	List<Task> queryByAssignee(String assignee);
	
	/**
	 * 通过流程实例ID查询任务
	 * （注意：流程必须是单线没有支线的，否则可能产生业务异常）
	 * @param processInstanceId 流程实例ID
	 * @return 任务
	 */
	List<Task> queryByProcessInstanceId(String processInstanceId);
	
	/**
	 * 查询超时任务
	 * @return 超时任务
	 */
	List<Task> queryTimeoutTask();

	/**
	 * 通过流程实例ID处理任务
	 * （注意：流程必须是单线没有支线的，否则可能产生业务异常，有支线的流程只能使用任务ID来定位并处理流程）
	 * @param processInstanceId 流程实例ID
	 * @param variables 参数
	 */
	void completeByProcessInstanceId(String processInstanceId, Map<String, Object> variables);

	/**
	 * 通过任务ID处理任务（建议使用本方法处理任务）
	 * @param taskId 任务ID
	 * @param variables 任务变量
	 */
	void completeByTaskId(String taskId, Map<String, Object> variables);

	/**
	 * 领取(分配)任务
	 * @param taskId 任务ID
	 * @param userId 用户ID
	 */
	void claim(String taskId, String userId);

	/**
	 * 通过任务ID获取流程实例ID
	 * @param taskId 任务ID
	 * @return 任务
	 */
	Task queryByTaskId(String taskId);

	/**
	 * 通过任务ID获取标识（可以获取任务限定用户组）
	 * @param taskId 任务ID
	 * @return 关系
	 */
	List<IdentityLink> getIdentityLinksForTask(String taskId);
	
	/**
	 * 设置到期时间
	 * @param taskId 任务ID
	 * @param dueDate 到期时间
	 */
	void setDueDate(String taskId,Date dueDate);
}
