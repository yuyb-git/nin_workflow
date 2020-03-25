package cn.netinnet.workflow.activiti.service.impl;

import cn.netinnet.workflow.common.base.BaseService;
import cn.netinnet.workflow.activiti.dao.FormPurchaseMapper;
import cn.netinnet.workflow.activiti.domain.FormPurchase;
import cn.netinnet.workflow.activiti.domain.FormPurchaseExample;
import cn.netinnet.workflow.activiti.service.FormPurchaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author yuyb
 * @date   2020-03-25
 */
@Service
public class FormPurchaseServiceImpl extends BaseService<FormPurchase,FormPurchaseExample> implements FormPurchaseService {
    @Resource
    private FormPurchaseMapper formPurchaseMapper;

    @Override
    public int insertSelective(FormPurchase formPurchase, long userId) {
        return formPurchaseMapper.insertSelective(formPurchase);
    }
    @Override
    public Class getClazz(){
        return FormPurchase.class;
    }
}