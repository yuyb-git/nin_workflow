package cn.netinnet.workflow.user.controller;

import cn.netinnet.workflow.common.base.BaseController;
import cn.netinnet.workflow.common.global.HttpResultEntry;
import cn.netinnet.workflow.user.domain.WorkflowUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/add")
    public ModelAndView add() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/bpmn/add");
        return mv;
    }

    @RequestMapping(value="get")
    public HttpResultEntry get(Integer id, HttpServletRequest request){
        WorkflowUser user =  this.getWorkflowUser(request);
        return HttpResultEntry.ok("", user);
    }

}
