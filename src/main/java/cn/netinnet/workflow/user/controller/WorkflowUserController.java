package cn.netinnet.workflow.user.controller;

import cn.netinnet.workflow.common.base.BaseController;
import cn.netinnet.workflow.common.constant.GlobalConstant;
import cn.netinnet.workflow.user.domain.WorkflowUser;
import cn.netinnet.workflow.common.global.HttpResultEntry;
import cn.netinnet.workflow.user.service.WorkflowUserService;

import com.github.pagehelper.PageInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;

/**
 * @author yuyb
 * @date   2020-03-06
 */
@RestController
@RequestMapping("/workflowUser")
public class WorkflowUserController extends BaseController {
    private final static Logger LOGGER = LoggerFactory.getLogger(WorkflowUserController.class);

    @Autowired
    WorkflowUserService workflowUserService;

    @PostMapping("/add")
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

    @GetMapping("/list")
    public HttpResultEntry list(WorkflowUser workflowUser,@RequestParam String pageFun) {
        PageInfo pageInfo = getPage(() -> {
            return workflowUserService.getList(workflowUser);
        });
        HttpResultEntry httpResultEntry = workflowUserService.returnPage2EJS(pageFun,pageInfo);
        return httpResultEntry;
    }

}


