package cn.netinnet.workflow.common.base;

import cn.netinnet.common.util.StringUtil;
import cn.netinnet.common.util.httpclient.RequestUtil;
import cn.netinnet.workflow.user.domain.WorkflowUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @Author Liyq [Liyq@netinnet.cn]
 * @Date 2017/12/4 14:47
 */
public abstract class BaseController {
    private static final Logger LOG = LoggerFactory.getLogger(BaseController.class);

    /**
     * @Author liyq liyq@netinnet.cn
     * @Date 2017/12/6 14:48
     * @param request
     * @return
     * @Description 获取所有的请求参数
     */
    public Map<String, String> getPara2Map(HttpServletRequest request){
        Enumeration<String> names = request.getParameterNames();
        Map<String, String> params = new HashMap<>();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String value = request.getParameter(name);
            LOG.debug("get parameter : "+name+"="+value);
            params.put(name, value);
        }
        return params;
    }

    public static PageInfo getPage(Supplier<List> supplier){
        String pageStr = RequestUtil.getParameter("page","0");
        Integer page = StringUtil.isBlank(pageStr)?0:Integer.valueOf(pageStr);
        String sizeStr = RequestUtil.getParameter("size");
        if(StringUtil.isNullOrEmpty(sizeStr)) {
            sizeStr =  RequestUtil.getParameter("limit","10");
        }
        Integer size = StringUtil.isBlank(pageStr)?10:Integer.valueOf(sizeStr);
        PageHelper.startPage(page, size);
        List list =  supplier.get();
        PageInfo pageInfo = new PageInfo(list);
        return  pageInfo;
    }

    protected WorkflowUser getWorkflowUser(HttpServletRequest request) {
        return (WorkflowUser) request.getSession().getAttribute("user");
    }

}
