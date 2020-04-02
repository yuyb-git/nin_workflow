package cn.netinnet.workflow.activiti.service.impl;

import cn.netinnet.workflow.common.base.BaseService;
import cn.netinnet.workflow.activiti.dao.FormLeaveMapper;
import cn.netinnet.workflow.activiti.domain.FormLeave;
import cn.netinnet.workflow.activiti.domain.FormLeaveExample;
import cn.netinnet.workflow.activiti.service.FormLeaveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author yuyb
 * @date   2020-03-31
 */
@Service
public class FormLeaveServiceImpl extends BaseService<FormLeave,FormLeaveExample> implements FormLeaveService {
    @Resource
    private FormLeaveMapper formLeaveMapper;

    @Override
    public int insertSelective(FormLeave formLeave, long userId) {
        return formLeaveMapper.insertSelective(formLeave);
    }
    @Override
    public Class getClazz(){
        return FormLeave.class;
    }
}