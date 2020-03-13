package cn.netinnet.workflow.junit;

import cn.netinnet.workflow.BaseTest;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @ClassName ActivitiJunitTest
 * @Description
 * @Author yuyb
 * @Date 2020/3/12 17:21
 */
public class ActivitiJunitTest extends BaseTest {

    @Resource
    RepositoryService repositoryService;

    @Test
    public void prepare() {
        Deployment deployment = repositoryService.createDeployment()//创建一个部署对象
                .name("请假流程")
                .addClasspathResource("processes/leaveProcess.bpmn")
                .addClasspathResource("processes/leaveProcess.png")
                .deploy();
        System.out.println("部署ID："+deployment.getId());
        System.out.println("部署名称："+deployment.getName());
    }

}
