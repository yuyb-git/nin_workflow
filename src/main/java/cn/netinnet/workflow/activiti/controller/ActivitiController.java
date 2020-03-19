package cn.netinnet.workflow.activiti.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ActivitiController
 * @Description
 * @Author yuyb
 * @Date 2020/3/12 17:21
 */
@Controller
@RequestMapping("/model")
public class ActivitiController {
	
	private static final Logger log = LoggerFactory.getLogger(ActivitiController.class);
	 
    @Resource
    RepositoryService repositoryService;
    @Resource
    RuntimeService runtimeService;
    @Resource
    TaskService taskService;

    @RequestMapping(value = "add")
    public ModelAndView index(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("model/add");
        return mv;
    }

    @RequestMapping(value = "spread")
    public ModelAndView spreadSheet(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("model/spread");
        return mv;
    }

    /**
     * 获取所有模型
     */
    @RequestMapping("/modelList")
    @ResponseBody
    public Object modelList(){
        return repositoryService.createModelQuery().list();
    }
 
    /**
     * 发布模型为流程定义
     */
    @RequestMapping("/deploy")
    @ResponseBody
    public Object deploy(String modelId) throws Exception {
 
        //获取模型
        Model modelData = repositoryService.getModel(modelId);
        byte[] bytes = repositoryService.getModelEditorSource(modelData.getId());
        if (bytes == null) {
            return "模型数据为空，请先设计流程并成功保存，再进行发布。";
        }
        JsonNode modelNode = new ObjectMapper().readTree(bytes);
        //BpmnModel model = new BpmnJsonConverter().convertToBpmnModel(modelNode);
        BpmnModel model = new BpmnModel();
        if(model.getProcesses().size()==0){
            return "数据模型不符要求，请至少设计一条主线流程。";
        }
        byte[] bpmnBytes = new BpmnXMLConverter().convertToXML(model);
        //发布流程
        String processName = modelData.getName() + ".bpmn20.xml";
        Deployment deployment = repositoryService.createDeployment()
                .name(modelData.getName())
                .addString(processName, new String(bpmnBytes, "UTF-8"))
                .deploy();
        modelData.setDeploymentId(deployment.getId());
        repositoryService.saveModel(modelData);
 
        return "SUCCESS";
    }
 
    /**
     *  启动流程
     */
    @RequestMapping("/start")
    @ResponseBody
    public Object startProcess(String keyName) {
        //设置assignee的取值，用户可以在界面上设置流程的执行人
        Map<String, Object> map = new HashMap<>(5);
        map.put("assignee0", "张三");
        map.put("assignee1", "李四");
        map.put("assignee2", "王五");
        ProcessInstance process = runtimeService.startProcessInstanceByKey(keyName, map);
        return process.getId() + " : " + process.getProcessDefinitionId();
    }
 
    /**
     *  提交任务
     */
    @RequestMapping("/run")
    @ResponseBody
    public Object run(String processInstanceId) {
        Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
        log.info("task {} find ", task.getId());
        taskService.complete(task.getId());
        return "SUCCESS";
    }

}
