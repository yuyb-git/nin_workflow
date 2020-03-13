package cn.netinnet.workflow.generator;

import static cn.netinnet.workflow.common.constant.ProjectConstant.BASE_PACKAGE;
import static cn.netinnet.workflow.common.constant.ProjectConstant.CONTROLLER_PACKAGE;
import static cn.netinnet.workflow.common.constant.ProjectConstant.MAPPER_INTERFACE_REFERENCE;
import static cn.netinnet.workflow.common.constant.ProjectConstant.MAPPER_PACKAGE;
import static cn.netinnet.workflow.common.constant.ProjectConstant.MODEL_PACKAGE;
import static cn.netinnet.workflow.common.constant.ProjectConstant.MOUDLE;
import static cn.netinnet.workflow.common.constant.ProjectConstant.SERVICE_IMPL_PACKAGE;
import static cn.netinnet.workflow.common.constant.ProjectConstant.SERVICE_PACKAGE;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.CommentGeneratorConfiguration;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.GeneratedKey;
import org.mybatis.generator.config.JDBCConnectionConfiguration;
import org.mybatis.generator.config.JavaClientGeneratorConfiguration;
import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
import org.mybatis.generator.config.JavaTypeResolverConfiguration;
import org.mybatis.generator.config.ModelType;
import org.mybatis.generator.config.PluginConfiguration;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.config.SqlMapGeneratorConfiguration;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.internal.DefaultShellCallback;

import com.google.common.base.CaseFormat;

import cn.netinnet.workflow.common.constant.ProjectConstant;
import freemarker.template.TemplateExceptionHandler;

/**
 * 代码生成器，根据数据表名称生成对应的Model、Mapper、Service、Controller简化开发。
 */
public class CodeGenerator {
    //JDBC配置，请修改为你项目的实际配置
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/nin_workflow";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "123456";
    private static final String JDBC_DIVER_CLASS_NAME = "com.mysql.jdbc.Driver";

    private static final String PROJECT_PATH = System.getProperty("user.dir");//项目在硬盘上的基础路径
    private static final String TEMPLATE_FILE_PATH = PROJECT_PATH + "/src/test/resources/generator/template";//模板位置

    private static final String JAVA_PATH = "/src/main/java"; //java文件路径
    private static final String RESOURCES_PATH = "/src/main/resources";//资源文件路径
    private static final String GENERATOR_PATH = ".generator"; // 生成工具存放目录

    private static final String PACKAGE_PATH_SERVICE = packageConvertPath(SERVICE_PACKAGE);//生成的Service存放路径
    private static final String PACKAGE_PATH_SERVICE_IMPL = packageConvertPath(SERVICE_IMPL_PACKAGE);//生成的Service实现存放路径
    private static final String PACKAGE_PATH_CONTROLLER = packageConvertPath(CONTROLLER_PACKAGE);//生成的Controller存放路径

    public static final String AUTHOR = "yuyb";//@author
    private static final String DATE = DateFormatUtils.format(new Date(), "yyyy-MM-dd");//@date

    /**
     * 主方法：传入需要生成的表名
     *
     * @param args
     */
    public static void main(String[] args) {
        //System.out.println(getAllTableNames());
        System.out.println("-----------------------------------------------------");
//        for(String table: getAllTableNames()) {
//            if(table.equals("lspt_jc_ll")) {
//                genCode(table);
//            }
//
//        }
        // genCode("match_teach_class_group_campaign","match_teach_class_group","match_teach_class_group_campaign_vote","match_sx_group_station","match_sys_option","match_sys_station");
        genCode("workflow_bpmn_model");
        //genCodeByCustomModelName("输入表名","输入自定义Model名称");
    }

    /**
     * 通过数据表名称生成代码，Model 名称通过解析数据表名称获得，下划线转大驼峰的形式。
     * 如输入表名称 "t_user_detail" 将生成 TUserDetail、TUserDetailMapper、TUserDetailService ...
     *
     * @param tableNames 数据表名称...
     */
    public static void genCode(String... tableNames) {
        for (String tableName : tableNames) {
            genCodeByCustomModelName(tableName, null);
        }
    }

    /**
     * 通过数据表名称，和自定义的 Model 名称生成代码
     * 如输入表名称 "t_user_detail" 和自定义的 Model 名称 "User" 将生成 User、UserMapper、UserService ...
     *
     * @param tableName 数据表名称
     * @param modelName 自定义的 Model 名称
     */
    public static void genCodeByCustomModelName(String tableName, String modelName) {
        genModelAndMapper(tableName, modelName);
        genService(tableName, modelName);
        //genController(tableName, modelName);
        getPrimaryKeyName(tableName);
    }


    public static void genModelAndMapper(String tableName, String modelName) {
        Context context = new Context(ModelType.FLAT);
        context.setId("Potato");
        // context.setTargetRuntime("MyBatis3Simple");
        context.setTargetRuntime("MyBatis3");
        context.addProperty(PropertyRegistry.CONTEXT_BEGINNING_DELIMITER, "`");
        context.addProperty(PropertyRegistry.CONTEXT_ENDING_DELIMITER, "`");

        // edit by xianlaioy at 20171211
        // 自定义类型转成 sql tinyint-->java int
        JavaTypeResolverConfiguration javaTypeResolverConfiguration = new JavaTypeResolverConfiguration();
        javaTypeResolverConfiguration.setConfigurationType(JavaTypeResolverDefault.class.getName());
        context.setJavaTypeResolverConfiguration(javaTypeResolverConfiguration);

        JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
        jdbcConnectionConfiguration.setConnectionURL(JDBC_URL);
        jdbcConnectionConfiguration.setUserId(JDBC_USERNAME);
        jdbcConnectionConfiguration.setPassword(JDBC_PASSWORD);
        jdbcConnectionConfiguration.setDriverClass(JDBC_DIVER_CLASS_NAME);
        context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);

        PluginConfiguration pluginConfiguration = new PluginConfiguration();
        //pluginConfiguration.setConfigurationType("tk.mybatis.mapper.generator.MapperPlugin");
        pluginConfiguration.setConfigurationType(ProjectConstant.BASE_PACKAGE + GENERATOR_PATH + ".GenPlugin");
        pluginConfiguration.addProperty("mappers", MAPPER_INTERFACE_REFERENCE);
        context.addPluginConfiguration(pluginConfiguration);

        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
        javaModelGeneratorConfiguration.setTargetProject(PROJECT_PATH + JAVA_PATH);
        javaModelGeneratorConfiguration.setTargetPackage(MODEL_PACKAGE);
        context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);

        SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
        sqlMapGeneratorConfiguration.setTargetProject(PROJECT_PATH + JAVA_PATH );
        sqlMapGeneratorConfiguration.setTargetPackage(MAPPER_PACKAGE+".mapper");
        context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);

        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
        javaClientGeneratorConfiguration.setTargetProject(PROJECT_PATH + JAVA_PATH);
        javaClientGeneratorConfiguration.setTargetPackage(MAPPER_PACKAGE);
        javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
        context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);

        TableConfiguration tableConfiguration = new TableConfiguration(context);
        tableConfiguration.setTableName(tableName);
        if (StringUtils.isNotEmpty(modelName)) tableConfiguration.setDomainObjectName(modelName);
        //GeneratedKey gk = new GeneratedKey("customer_id", "Mysql", true, null);
        GeneratedKey gk = new GeneratedKey(getPrimaryKeyName(tableName), "JDBC", true, null);
        tableConfiguration.setGeneratedKey(gk);

        CommentGeneratorConfiguration commentGenerator = new CommentGeneratorConfiguration();
        commentGenerator.addProperty("suppressDate", "true");
        commentGenerator.addProperty("suppressAllComments", "true");
        commentGenerator.setConfigurationType(ProjectConstant.BASE_PACKAGE + GENERATOR_PATH + ".GenCommentGenerator");
        context.setCommentGeneratorConfiguration(commentGenerator);
        context.addTableConfiguration(tableConfiguration);

        List<String> warnings;
        MyBatisGenerator generator;
        try {
            Configuration config = new Configuration();
            config.addContext(context);
            config.validate();

            boolean overwrite = true;
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            warnings = new ArrayList<String>();
            generator = new MyBatisGenerator(config, callback, warnings);
            generator.generate(null);
        } catch (Exception e) {
            throw new RuntimeException("生成Model和Mapper失败", e);
        }

        if (generator.getGeneratedJavaFiles().isEmpty() || generator.getGeneratedXmlFiles().isEmpty()) {
            throw new RuntimeException("生成Model和Mapper失败：" + warnings);
        }
        if (StringUtils.isEmpty(modelName)) modelName = tableNameConvertUpperCamel(tableName);
        System.out.println(modelName + ".java 生成成功");
        System.out.println(modelName + "Mapper.java 生成成功");
        System.out.println(modelName + "Mapper.xml 生成成功");
    }

    public static void genService(String tableName, String modelName) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();

            Map<String, Object> data = new HashMap<>();
            data.put("date", DATE);
            data.put("author", AUTHOR);
            String modelNameUpperCamel = StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", tableNameConvertLowerCamel(tableName));
            data.put("basePackage", BASE_PACKAGE);
            data.put("module", MOUDLE);
            data.put("keyName", tableNameConvertUpperCamel(getPrimaryKeyName(tableName)));
            File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_SERVICE + modelNameUpperCamel + "Service.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("service.ftl").process(data,
                    new FileWriter(file));
            System.out.println(modelNameUpperCamel + "Service.java 生成成功");

            File file1 = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_SERVICE_IMPL + modelNameUpperCamel + "ServiceImpl.java");
            if (!file1.getParentFile().exists()) {
                file1.getParentFile().mkdirs();
            }
            cfg.getTemplate("service-impl.ftl").process(data,
                    new FileWriter(file1));
            System.out.println(modelNameUpperCamel + "ServiceImpl.java 生成成功");
        } catch (Exception e) {
            throw new RuntimeException("生成Service失败", e);
        }
    }

    public static void genController(String tableName, String modelName) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();

            Map<String, Object> data = new HashMap<>();
            data.put("date", DATE);
            data.put("author", AUTHOR);
            String modelNameUpperCamel = StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
            data.put("baseRequestMapping", modelNameConvertMappingPath(modelNameUpperCamel));
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, modelNameUpperCamel));
            data.put("basePackage", BASE_PACKAGE);
            data.put("module", MOUDLE);
            data.put("keyName", tableNameConvertUpperCamel(getPrimaryKeyName(tableName)));

            File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_CONTROLLER + modelNameUpperCamel + "Controller.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            //cfg.getTemplate("controller-restful.ftl").process(data, new FileWriter(file));
            cfg.getTemplate("controller.ftl").process(data, new FileWriter(file));

            System.out.println(modelNameUpperCamel + "Controller.java 生成成功");
        } catch (Exception e) {
            throw new RuntimeException("生成Controller失败", e);
        }
    }

    private static freemarker.template.Configuration getConfiguration() throws IOException {
        freemarker.template.Configuration cfg = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_23);
        cfg.setDirectoryForTemplateLoading(new File(TEMPLATE_FILE_PATH));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
        return cfg;
    }

    private static String tableNameConvertLowerCamel(String tableName) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, tableName.toLowerCase());
    }

    private static String tableNameConvertUpperCamel(String tableName) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tableName.toLowerCase());
    }

    private static String tableNameConvertMappingPath(String tableName) {
        //兼容使用大写的表名
        tableName = tableName.toLowerCase();
        return "/" + (tableName.contains("_") ? tableName.replaceAll("_", "/") : tableName);
    }

    private static String modelNameConvertMappingPath(String modelName) {
        String tableName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, modelName);
        return tableNameConvertMappingPath(tableName);
    }

    private static String packageConvertPath(String packageName) {
        return String.format("/%s/", packageName.contains(".") ? packageName.replaceAll("\\.", "/") : packageName);
    }

    private static String getPrimaryKeyName(String table) {
        try {
            Class.forName(JDBC_DIVER_CLASS_NAME).newInstance();
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            PreparedStatement ps = conn.prepareStatement("desc " + table);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsme = rs.getMetaData();

            int columnCount = rsme.getColumnCount();
            // System.out.println("-----------------------------------------------------");
            // System.out.println("查看表结构的详细信息：desc");
            // System.out.println("ResultSet对象中的列数" + columnCount);
            while (rs.next()) {
                String columnName = rs.getString("Field");
                String columnType = rs.getString("Type");
                String pri = rs.getString("Key");
                // System.out.println(columnName + " " + columnType + " " + pri);
                if ("PRI".equals(pri)) {
                    // System.out.println(tableNameConvertUpperCamel(columnName));
                    // System.out.println("-----------------------------------------------------");
                    return columnName;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static List<String> getAllTableNames() {
        List<String> list = new ArrayList<>();
        try {
            Class.forName(JDBC_DIVER_CLASS_NAME).newInstance();
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            PreparedStatement ps = conn.prepareStatement("show tables ");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsme = rs.getMetaData();

            int columnCount = rsme.getColumnCount();
            // System.out.println("-----------------------------------------------------");
            // System.out.println("显示当前数据库中所有表的名称：show table");
            // System.out.println("ResultSet对象中的列数" + columnCount);
            while (rs.next()) {
                String columnName = rs.getString(1);
                list.add(columnName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}