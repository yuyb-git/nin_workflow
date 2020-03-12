package cn.netinnet.workflow.user.controller;

import cn.netinnet.workflow.common.base.BaseController;
import cn.netinnet.workflow.common.constant.GlobalConstant;
import cn.netinnet.workflow.user.dao.WorkflowUserMapper;
import cn.netinnet.workflow.user.domain.WorkflowUser;
import cn.netinnet.workflow.common.global.HttpResultEntry;
import cn.netinnet.workflow.user.service.WorkflowUserService;

import com.github.pagehelper.PageInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author yuyb
 * @date   2020-03-06
 */
@RestController
@RequestMapping("/user")
public class WorkflowUserController extends BaseController {
    private final static Logger LOGGER = LoggerFactory.getLogger(WorkflowUserController.class);

    @Resource
    WorkflowUserService workflowUserService;
    @Resource
    WorkflowUserMapper workflowUserMapper;

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/user/index");
        return mv;
    }

    @RequestMapping("/add")
    public ModelAndView add() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/user/add");
        return mv;
    }

    @PostMapping("/addUser")
    public HttpResultEntry add(WorkflowUser workflowUser, HttpSession session) {
        long userId = (Long) session.getAttribute("userId");
        workflowUserService.insertSelective(workflowUser, userId);
        return HttpResultEntry.ok(GlobalConstant.SUCCESS_MSG, workflowUser);
    }

    @GetMapping("/detail")
    public HttpResultEntry detail(@RequestParam int id) {
        WorkflowUser workflowUser = workflowUserService.selectById(id);
        return HttpResultEntry.ok(GlobalConstant.SUCCESS_MSG, workflowUser);
    }

    @RequestMapping(value="remove")
    public HttpResultEntry remove(Long id, HttpServletRequest request){
        workflowUserService.deleteById(id);
        return HttpResultEntry.ok();
    }

    @RequestMapping("/list")
    public HttpResultEntry list() {
        PageInfo pageInfo = getPage(() -> {
            return workflowUserMapper.selectAllUser();
        });
        HttpResultEntry httpResultEntry = workflowUserService.returnPage2EJS("",pageInfo);
        return httpResultEntry;
    }

}


