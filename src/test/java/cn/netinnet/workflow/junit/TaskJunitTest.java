package cn.netinnet.workflow.junit;

import cn.netinnet.workflow.BaseTest;
import cn.netinnet.workflow.activiti.Leave;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TaskJunitTest
 * @Description
 * @Author yuyb
 * @Date 2020/3/17 15:46
 */
public class TaskJunitTest extends BaseTest {

    @Resource
    RepositoryService repositoryService;
    @Resource
    TaskService taskService;
    @Resource
    RuntimeService runtimeService;

    private static final Logger logger = LoggerFactory.getLogger(TaskJunitTest.class);
    private static ObjectMapper mapper = new ObjectMapper();

    @Test
    @Rollback(false)
    public void testFullProcess() throws Exception {
        //流程部署
        System.out.println("##################[流程部署]######################################");
        Deployment deployment = repositoryService.createDeployment()//创建一个部署对象
                .name("请假流程")
                .addClasspathResource("processes/leaveProcess.bpmn")
                .addClasspathResource("processes/leaveProcess.png")
                .deploy();
        System.out.println("部署ID："+deployment.getId());
        System.out.println("部署名称："+deployment.getName());
        String jdeployment = mapper.writeValueAsString(deployment);
        System.out.println("=====流程部署信息:"+jdeployment);
        logger.info("=====流程部署信息:"+jdeployment);

        Leave leave = new Leave();
        leave.setLeaveId("leaveId-2019");
        leave.setDays("3");
        leave.setUserId("张三");
        leave.setLeaveReason("生病");
        leave.setLeaveStatus("审批中");

        String processDefinitionKey = "leaveprocess";
        Map<String,Object> leavemap = new HashMap<>();
        leavemap.put("LeaveId", leave.getLeaveId());
        leavemap.put("Days", leave.getDays());
        leavemap.put("UserId", leave.getUserId());
        leavemap.put("LeaveStatus", leave.getLeaveStatus());
        leavemap.put("ProcessInstanceId", leave.getProcessInstanceId());
        String jleavemap = mapper.writeValueAsString(leavemap);
        System.out.println("=====流程启动参数:"+jleavemap);
        logger.info("=====流程启动参数:"+jleavemap);

        //启动请假流程
        System.out.println("##################[流程启动]######################################");
        ProcessInstance pins = runtimeService.startProcessInstanceByKey(processDefinitionKey,leavemap);

        leave.setProcessInstanceId(pins.getProcessInstanceId());
        String jleave = mapper.writeValueAsString(leave);
        System.out.println("=====请假信息:"+jleave);
        logger.info("=====请假信息:"+jleave);
        logger.info("==============保存请假单完成=================");

        System.out.println("流程实例ID:"+pins.getProcessInstanceId()+"&流程定义ID:"+pins.getProcessDefinitionId());
        logger.info("流程实例ID:"+pins.getProcessInstanceId()+"&流程定义ID:"+pins.getProcessDefinitionId());

        //1.根据张三的userid查询请假单表查询出分页列状态为已发起
        System.out.println("##################[张三任务]-发起申请######################################");
        //张三查询个人列表
        List<Task> zhagnsanTask = taskService
                .createTaskQuery()
                .taskAssignee(leave.getUserId())
                .processInstanceId(leave.getProcessInstanceId())
                .list();
        for (Task task : zhagnsanTask) {
            System.out.println("任务ID:"+task.getId());
            System.out.println("任务名称:"+task.getName());
            System.out.println("任务的创建时间:"+task.getCreateTime());
            System.out.println("任务的办理人:"+task.getAssignee());
            System.out.println("流程实例ID："+task.getProcessInstanceId());
            System.out.println("执行对象ID:"+task.getExecutionId());
            System.out.println("流程定义ID:"+task.getProcessDefinitionId());
            taskService.complete(task.getId());
        }

        System.out.println("##################[李四任务]-任务待办######################################");
        //李四查询代办任务
        List<Task> lisiTask = taskService
                .createTaskQuery()
                .taskAssignee("李四")
                .processInstanceId(leave.getProcessInstanceId())
                .list();
        for (Task task : lisiTask) {
            System.out.println("任务ID:"+task.getId());
            System.out.println("任务名称:"+task.getName());
            System.out.println("任务的创建时间:"+task.getCreateTime());
            System.out.println("任务的办理人:"+task.getAssignee());
            System.out.println("流程实例ID："+task.getProcessInstanceId());
            System.out.println("执行对象ID:"+task.getExecutionId());
            System.out.println("流程定义ID:"+task.getProcessDefinitionId());
        }
        System.out.println("##################[李四任务]-同意申请######################################");

        Authentication.setAuthenticatedUserId("李四");
        System.out.println("审批意见:"+"同意请假-设置请假单状态为-已完成");
        taskService.addComment(lisiTask.get(0).getId(), lisiTask.get(0).getProcessInstanceId(), "同意我的员工请假");
        taskService.complete(lisiTask.get(0).getId());
        System.out.println("##################[审批意见-同意]-同意申请######################################");
    }

}
