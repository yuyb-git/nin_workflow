package ${BASE_PACKAGE_MODULE}.service.impl;

import ${basePackage}.common.base.BaseService;
import ${BASE_PACKAGE_MODULE}.dao.${modelNameUpperCamel}Mapper;
import ${BASE_PACKAGE_MODULE}.domain.${modelNameUpperCamel};
import ${BASE_PACKAGE_MODULE}.domain.${modelNameUpperCamel}Example;
import ${BASE_PACKAGE_MODULE}.service.${modelNameUpperCamel}Service;
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