package cn.netinnet.workflow.activiti.service.impl;

import cn.netinnet.workflow.common.base.BaseService;
import cn.netinnet.workflow.activiti.dao.FormMaterialMapper;
import cn.netinnet.workflow.activiti.domain.FormMaterial;
import cn.netinnet.workflow.activiti.domain.FormMaterialExample;
import cn.netinnet.workflow.activiti.service.FormMaterialService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author yuyb
 * @date   2020-03-25
 */
@Service
public class FormMaterialServiceImpl extends BaseService<FormMaterial,FormMaterialExample> implements FormMaterialService {
    @Resource
    private FormMaterialMapper formMaterialMapper;

    @Override
    public int insertSelective(FormMaterial formMaterial, long userId) {
        return formMaterialMapper.insertSelective(formMaterial);
    }
    @Override
    public Class getClazz(){
        return FormMaterial.class;
    }
}