package ${basePackage}.activiti.service.impl;

import ${basePackage}.common.base.BaseService;
import ${basePackage}.activiti.dao.${modelNameUpperCamel}Mapper;
import ${basePackage}.activiti.domain.${modelNameUpperCamel};
import ${basePackage}.activiti.domain.${modelNameUpperCamel}Example;
import ${basePackage}.activiti.service.${modelNameUpperCamel}Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author ${author}
 * @date   ${date}
 */
@Service
public class ${modelNameUpperCamel}ServiceImpl extends BaseService<${modelNameUpperCamel},${modelNameUpperCamel}Example> implements ${modelNameUpperCamel}Service {
    @Resource
    private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;

    @Override
    public int insertSelective(${modelNameUpperCamel} ${modelNameLowerCamel}, long userId) {
        return ${modelNameLowerCamel}Mapper.insertSelective(${modelNameLowerCamel});
    }
    @Override
    public Class getClazz(){
        return ${modelNameUpperCamel}.class;
    }
}