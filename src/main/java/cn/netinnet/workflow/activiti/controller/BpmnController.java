package cn.netinnet.workflow.activiti.controller;

import cn.netinnet.common.util.DateUtil;
import cn.netinnet.workflow.activiti.domain.WorkflowBpmnModel;
import cn.netinnet.workflow.activiti.service.WorkflowBpmnModelService;
import cn.netinnet.workflow.common.base.BaseController;
import cn.netinnet.workflow.common.global.HttpResultEntry;
import cn.netinnet.workflow.user.domain.WorkflowUser;
import cn.netinnet.workflow.util.ImageUtil;
import cn.netinnet.workflow.util.StringUtilForFile;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.pagehelper.PageInfo;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Model;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.UUID;

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
    RepositoryService repositoryService;
    @Resource
    WorkflowBpmnModelService workflowBpmnModelService;
    @Resource
    ObjectMapper objectMapper;

    @RequestMapping("/bpmn")
    public ModelAndView bpmn() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/bpmn/bpmn");
        return mv;
    }

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
    public HttpResultEntry save(String bpmnXml, String modelName, HttpServletRequest request) throws DocumentException {

        String bpmnPath = (String)request.getServletContext().getAttribute("bpmnPath");
        if(!bpmnPath.endsWith(File.separator)) {
            bpmnPath += File.separator;
        }
        bpmnPath = StringUtilForFile.getAbsolutePath(bpmnPath);
        String fileName = bpmnPath + modelName + ".bpmn";
        Document document = DocumentHelper.parseText(bpmnXml);
        StringUtilForFile.outputXml(document, fileName);

        //上传原图片
        //ImageUtil.imageUpload(bpmnPath, file, modelName);
        ObjectNode modelObjectNode = objectMapper.createObjectNode();
        //保存act_re_model
        Model newModel = repositoryService.newModel();
        newModel.setName(modelName);
        newModel.setCategory("请假单");
        newModel.setKey(UUID.randomUUID().toString());
        newModel.setMetaInfo("请假单-v1-");
        repositoryService.saveModel(newModel);

        WorkflowUser user =  this.getWorkflowUser(request);
        WorkflowBpmnModel bpmn = new WorkflowBpmnModel();
        bpmn.setModelId(DateUtil.getUID());
        bpmn.setActivitiModelId(newModel.getId());
        bpmn.setModelName(modelName);
        bpmn.setBpmnImgae("");
        bpmn.setBpmnXml("");
        bpmn.setCreateUserId(1L);
        bpmn.setCreateTime(new Date());
        workflowBpmnModelService.insertSelective(bpmn, user.getId());
        return HttpResultEntry.ok("保存成功", bpmn.getModelId());
    }

    @RequestMapping("/list")
    public HttpResultEntry list() {

        PageInfo pageInfo = getPage(() -> {
            return repositoryService.createModelQuery().list();
        });
        return workflowBpmnModelService.returnPage2EJS("",pageInfo);
    }

}
