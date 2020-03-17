package cn.netinnet.workflow.junit;

import cn.netinnet.workflow.BaseTest;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
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
    @Resource
    RuntimeService runtimeService;

    @Test
    @Rollback(false)
    public void deploy() {

        Deployment deployment = repositoryService.createDeployment()//创建一个部署对象
                .name("请假流程")
                .addClasspathResource("processes/leaveProcess.bpmn")
                .addClasspathResource("processes/leaveProcess.png")
                .deploy();
        System.out.println("部署ID："+deployment.getId());
        System.out.println("部署名称："+deployment.getName());
        // 流程部署表 select * from act_re_deployment;
        // 流程定义表 select * from act_re_procdef;
        // 资源文件表 select * from act_ge_bytearray;
    }

    @Test
    @Rollback(false)
    public void start() {
        // 生成运行时流程任务节点表：act_ru_task、
        //`act_ru_task表的EXECUTION_ID_``PROC_INST_ID_`分别为act_ru_execution的两条记录主键
        // 生成运行时流程执行实例表：act_ru_execution、
        // 生成运行时变量表：act_ru_variable
        String id = "myProcess_1:1:5869e9ee-6767-11ea-acd5-18dbf2291890";
        Map<String, Object> map = new HashMap<>();
        map.put("assignee0", "张三");
        map.put("assignee1", "李四");
        map.put("assignee2", "王五");
        ProcessInstance process = runtimeService.startProcessInstanceById(id, map);
        System.out.println("流程id：" + process.getId());
        System.out.println("流程定义id：" + process.getProcessDefinitionId());
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
