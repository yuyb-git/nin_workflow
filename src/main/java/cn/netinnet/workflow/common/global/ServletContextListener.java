package cn.netinnet.workflow.common.global;

import cn.netinnet.common.util.StringUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * @ClassName ServletContextListener
 * @Description
 * @Author yuyb
 * @Date 2020/3/13 14:07
 */
@Component
public class ServletContextListener implements InitializingBean, ServletContextAware {

    /**
     * cdn项目通用文件
     */
    @Value("${app.bpmn-path}")
    private String bpmnPath;

    //通用文件默认路径
    private String defaultbpmnPath = "/processes";

    @Override
    public void setServletContext(ServletContext servletContext) {
        String contextPath = servletContext.getContextPath() + "/";
        //项目访问目录
        servletContext.setAttribute("contextPath", contextPath);
        //如果没有配置,访问本项目
        if (StringUtil.isEmpty(bpmnPath)) {
            bpmnPath = defaultbpmnPath;
        }
        servletContext.setAttribute("bpmnPath", bpmnPath);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

}
