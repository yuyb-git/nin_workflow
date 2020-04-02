package cn.netinnet.workflow.user.controller;

import cn.netinnet.workflow.common.base.BaseController;
import cn.netinnet.workflow.common.global.HttpResultEntry;
import cn.netinnet.workflow.user.domain.WorkflowUser;
import cn.netinnet.workflow.user.service.WorkflowUserService;
import cn.netinnet.workflow.util.MD5Utils;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName LoginController
 * @Description
 * @Author yuyb
 * @Date 2020/3/12 10:50
 */
@RestController
@RequestMapping("/")
@Api(value = "LoginController|登录退出相关接口")
public class LoginController extends BaseController {

    @Resource
    WorkflowUserService workflowUserService;

    @GetMapping(value = "/swagger")
    public ModelAndView swagger() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:swagger-ui.html");
        return mv;
    }

    @GetMapping("/")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/login");
        return mv;
    }

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/main");
        return mv;
    }

    @PostMapping(value="login")
    public HttpResultEntry login(String username, String password, HttpServletRequest request) {
        WorkflowUser user = workflowUserService.getWorkflowUserByName(username);
        if(user==null) {
            return HttpResultEntry.error("用户不存在");
        }else {
            if(MD5Utils.getSaltverifyMD5(password, user.getPassword())) {

                UsernamePasswordToken token = new UsernamePasswordToken(username, password);
                Subject currentUser = SecurityUtils.getSubject();
                currentUser.login(token);

                request.getSession().setAttribute("user", user);
                return HttpResultEntry.ok();
            }else {
                return HttpResultEntry.error("密码错误");
            }
        }
    }

    @GetMapping(value="getUser")
    public HttpResultEntry getUser(HttpServletRequest request){
        WorkflowUser user =  (WorkflowUser) request.getSession().getAttribute("user");
        return HttpResultEntry.ok("操作成功", user);
    }

    @GetMapping(value="logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.sendRedirect("login.html");
    }

}
