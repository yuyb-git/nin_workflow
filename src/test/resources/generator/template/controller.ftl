package ${basePackage}.controller;

import ${basePackage}.common.base.BaseController;
import ${basePackage}.domain.${modelNameUpperCamel};
import ${basePackage}.common.constant.GlobalConstant;
import ${basePackage}.common.global.HttpResultEntry;
import ${basePackage}.service.${modelNameUpperCamel}Service;

import com.github.pagehelper.PageInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;

/**
 * @author ${author}
 * @date   ${date}
 */
@RestController
@RequestMapping("/${modelNameLowerCamel}")
public class ${modelNameUpperCamel}Controller extends BaseController {
    private final static Logger LOGGER = LoggerFactory.getLogger(${modelNameUpperCamel}Controller.class);

    @Autowired
    ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @PostMapping("/add")
    public HttpResultEntry add(${modelNameUpperCamel} ${modelNameLowerCamel}, HttpSession session) {
        long userId = (Long) session.getAttribute("userId");
        ${modelNameLowerCamel}Service.insertSelective(${modelNameLowerCamel}, userId);
        return HttpResultEntry.ok(GlobalConstant.SUCCESS_MSG, ${modelNameLowerCamel});
    }

    @GetMapping("/detail")
    public HttpResultEntry detail(@RequestParam int id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.selectById(id);
        return HttpResultEntry.ok(GlobalConstant.SUCCESS_MSG, ${modelNameLowerCamel});
    }

    @GetMapping("/list")
    public HttpResultEntry list(${modelNameUpperCamel} ${modelNameLowerCamel},@RequestParam String pageFun) {
        PageInfo pageInfo = getPage(() -> {
            return ${modelNameLowerCamel}Service.getList(${modelNameLowerCamel});
        });
        HttpResultEntry httpResultEntry = ${modelNameLowerCamel}Service.returnPage2EJS(pageFun,pageInfo);
        return httpResultEntry;
    }

}


