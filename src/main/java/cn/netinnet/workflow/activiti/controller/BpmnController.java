package cn.netinnet.workflow.activiti.controller;

import cn.netinnet.common.util.DateUtil;
import cn.netinnet.workflow.activiti.domain.WorkflowBpmnModel;
import cn.netinnet.workflow.activiti.service.WorkflowBpmnModelService;
import cn.netinnet.workflow.common.base.BaseController;
import cn.netinnet.workflow.common.global.HttpResultEntry;
import cn.netinnet.workflow.user.domain.WorkflowUser;
import com.github.pagehelper.PageInfo;
import org.activiti.bpmn.model.BpmnModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName BpmnController
 * @Description
 * @Author yuyb
 * @Date 2020/3/12 14:04
 */
@RestController
@RequestMapping("/bpmn")
public class BpmnController extends BaseController {

    @Resource
    WorkflowBpmnModelService workflowBpmnModelService;

    @RequestMapping("/add")
    public ModelAndView add() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/bpmn/add");
        return mv;
    }

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/bpmn/index");
        return mv;
    }

    @RequestMapping(value="get")
    public HttpResultEntry get(Integer id, HttpServletRequest request){
        WorkflowUser user =  this.getWorkflowUser(request);
        return HttpResultEntry.ok("", user);
    }

    @RequestMapping(value="save")
    public HttpResultEntry save(String modelName, HttpServletRequest request) {
        WorkflowUser user =  this.getWorkflowUser(request);
        WorkflowBpmnModel bpmn = new WorkflowBpmnModel();
        bpmn.setModelId(DateUtil.getUID());
        bpmn.setActivitiModelId("");
        bpmn.setModelName(modelName);
        workflowBpmnModelService.insertSelective(bpmn, user.getId());
        return HttpResultEntry.ok("保存成功", bpmn.getModelId());
    }

    /*@RequestMapping("/list")
    public HttpResultEntry list() {
        PageInfo pageInfo = getPage(() -> {
            return workflowUserMapper.selectAllUser();
        });
        HttpResultEntry httpResultEntry = workflowUserService.returnPage2EJS("",pageInfo);
        return httpResultEntry;
    }*/

}
