package cn.netinnet.workflow.junit;

import cn.netinnet.workflow.BaseTest;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ActivitiJunitTest
 * @Description
 * @Author yuyb
 * @Date 2020/3/12 17:21
 */
public class ActivitiJunitTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(ActivitiJunitTest.class);

    @Resource
    RepositoryService repositoryService;
    @Resource
    TaskService taskService;

    @Test
    @Rollback(false)
    public void prepare() {

        Deployment deployment = repositoryService.createDeployment()//创建一个部署对象
                .name("请假流程")
                .addClasspathResource("processes/leaveProcess.bpmn")
                .addClasspathResource("processes/leaveProcess.png")
                .deploy();
        System.out.println("部署ID："+deployment.getId());
        System.out.println("部署名称："+deployment.getName());
    }

    @Test
    public void queryProcessDefinition() {
        String processDefinitionKey = "holiday";
        //查询流程定义
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        List<ProcessDefinition> list = processDefinitionQuery.processDefinitionKey(processDefinitionKey)
                .orderByProcessDefinitionVersion().desc().list();
        for (ProcessDefinition processDefinition : list) {
            log.info("------------------------");
            log.info("流  程  部  署id：" + processDefinition.getDeploymentId());
            log.info("流程定义id：" + processDefinition.getId());
            log.info("流程定义名称：" + processDefinition.getName());
            log.info("流程定义key：" + processDefinition.getKey());
            log.info("流程定义版本：" + processDefinition.getVersion());
        }
    }

    /**
     * 删除已经部署成功的流程定义
     * 背后影响的表:
     * act_ge_bytearray
     * act_re_deployment
     * act_re_procdef
     */
    @Test
    public void deleteDeployment() {
        String deploymentId = "a2833cf7-10bb-11ea-9ac9-00155d65d6c0";
        //删除流程定义，如果该流程定义已有流程实例启动则删除时出错
        //repositoryService.deleteDeployment(deploymentId);
        //设置true 级联删除流程定义，即使该流程有流程实例启动也可以删除，设置为false非级别删除方式，如果流程
        repositoryService.deleteDeployment(deploymentId, true);
    }

    /**
     * @Author yuyb
     * @Description 查询某个人的任务
     * @Date 10:13 2020/3/17
     * @param
     * @return void
     **/
    @Test
    public void findPersonalTaskList() {
        String processDefinitionKey = "holiday2";
        String assignee = "赵六";
        List<Task> taskList = taskService.createTaskQuery()
                .processDefinitionKey(processDefinitionKey)
                .includeProcessVariables().taskAssignee(assignee).list();

        for (Task task : taskList) {
            System.out.println("--------------------------------------");
            System.out.println("流程实例id:" + task.getProcessInstanceId());
            System.out.println("任务id:" + task.getId());
            System.out.println("任务负责人:" + task.getAssignee());
            System.out.println("任务名称:" + task.getName());
        }
    }

}
