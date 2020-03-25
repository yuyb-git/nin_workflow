package cn.netinnet.workflow.activiti.service.impl;

import cn.netinnet.workflow.common.base.BaseService;
import cn.netinnet.workflow.activiti.dao.FormJsonMapper;
import cn.netinnet.workflow.activiti.domain.FormJson;
import cn.netinnet.workflow.activiti.domain.FormJsonExample;
import cn.netinnet.workflow.activiti.service.FormJsonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author yuyb
 * @date   2020-03-25
 */
@Service
public class FormJsonServiceImpl extends BaseService<FormJson,FormJsonExample> implements FormJsonService {
    @Resource
    private FormJsonMapper formJsonMapper;

    @Override
    public int insertSelective(FormJson formJson, long userId) {
        return formJsonMapper.insertSelective(formJson);
    }
    @Override
    public Class getClazz(){
        return FormJson.class;
    }
}