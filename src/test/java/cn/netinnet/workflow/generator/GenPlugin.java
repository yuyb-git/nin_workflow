package cn.netinnet.workflow.generator;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomUtils;
import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.ShellRunner;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.Element;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;

/**
 * @version 1.0.0
 */
public class GenPlugin extends PluginAdapter {
    /**
     * 生成dao
     */
    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType("BaseMapper<" + introspectedTable.getBaseRecordType() + ", " + introspectedTable.getBaseRecordType() + "Example>");
        FullyQualifiedJavaType imp = new FullyQualifiedJavaType( "cn.netinnet.workflow.common.base.BaseMapper");
        // 添加 extends BaseMapper<T>
        interfaze.addSuperInterface(fqjt);
        // 添加import base.BaseMapper;
        interfaze.addImportedType(imp);
        interfaze.getMethods().clear();
        return true;
    }

    /**
     * 生成实体中每个属性
     */
    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass,
                                              IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return true;
    }

    /**
     * 生成实体
     */
    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        addSerialVersionUID(topLevelClass, introspectedTable);
        generateToString(introspectedTable, topLevelClass);
        return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
    }
    
    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,
    		IntrospectedTable introspectedTable) {
    	// TODO Auto-generated method stub
    	return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
    }

    /**
     * 生成mapping
     */
    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        try {
            java.lang.reflect.Field field = sqlMap.getClass().getDeclaredField("isMergeable");
            field.setAccessible(true);
            field.setBoolean(sqlMap, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    @Override
    public boolean clientInsertSelectiveMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        return super.clientInsertSelectiveMethodGenerated(method, interfaze, introspectedTable);
    }

    /**
     * 获取columnNames
     * col1,col2
     */
    public String getColunNames(IntrospectedTable introspectedTable) {
        String clounNames = introspectedTable.getPrimaryKeyColumns().stream().map(introspectedColumn -> {
            return MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn);

        }).collect(Collectors.joining(", "));

        return clounNames + "," + introspectedTable.getNonPrimaryKeyColumns().stream().map(introspectedColumn -> {
            return MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn);

        }).collect(Collectors.joining(", "));
    }

    /**
     * 生成mapping 添加自定义sql
     */
    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        XmlElement rootElement = document.getRootElement();
        // 数据库表名
        String tableName = introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();
        // 主键
        List<IntrospectedColumn> pkColumnList = introspectedTable.getPrimaryKeyColumns();
        // 主键查询条件
        StringBuilder keySQL = new StringBuilder();

        // IF判断语句
        StringBuilder ifSQL = new StringBuilder();
        // 要插入的字段(排除自增主键)
        StringBuilder saveColumn = new StringBuilder("insert into ").append(tableName).append("\n").append("\t<trim prefix=\"(\" suffix=\") values\" prefixOverrides=\",\">\n");
        // 要插入的字段(排除自增主键, 不判断是否为null)
        StringBuilder saveColumn2 = new StringBuilder("insert into ").append(tableName).append("\n").append("\t<trim prefix=\"(\" suffix=\") values\" suffixOverrides=\",\">\n\t\t");
        // insertSelective
        StringBuilder insertSelectiveSql = new StringBuilder("insert into ").append(tableName).append("\n").append("\t<trim prefix=\"(\" suffix=\") \" suffixOverrides=\",\">\n");
        // 要保存的值
        StringBuilder saveValue = new StringBuilder().append("<trim prefix=\"(\" suffix=\")\" prefixOverrides=\",\">\n");
        // 要保存的值（不判断是否为null）
        StringBuilder saveValue2 = new StringBuilder().append("<trim prefix=\"(\" suffix=\")\" prefixOverrides=\",\">\n");
        // insertSelectiveSql values
        StringBuilder insertSelectiveValues = new StringBuilder("\n\t <trim prefix=\" values(\" suffix=\")\" suffixOverrides=\",\">\n");

        // 拼装更新字段
        StringBuilder updateSQL = new StringBuilder("update ").append(tableName).append(" set ").append("\n").append("\t<trim prefix=\"\" suffix=\"\" prefixOverrides=\",\">\n");

        // 数据库字段名
        String columnName = null;
        // java字段名
        String javaProperty = null;
        for (IntrospectedColumn introspectedColumn : introspectedTable.getAllColumns()) {
            columnName = MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn);
            javaProperty = introspectedColumn.getJavaProperty();

            // 拼接IF语句
            ifSQL.append("\t\t<if test=\"null != item.").append(javaProperty).append("\">");
            ifSQL.append("and ").append(columnName).append(" = #{item.").append(javaProperty).append("}</if>\n");

            // 拼接SQL
            if (!introspectedColumn.isAutoIncrement()) {
                // 拼接字段
                saveColumn.append("\t\t<if test=\"null != list[0].").append(javaProperty).append("\">, ").append(columnName).append("</if>\n");
                if (!"create_time".equals(columnName) && !"modify_time".equals(columnName)) {
                    saveColumn2.append(columnName).append(",");
                }
                insertSelectiveSql.append("\t\t<if test=\"null != ").append(javaProperty).append("\"> ").append(columnName).append(",</if>\n");
                saveValue.append("\t\t<if test=\"null != item.").append(javaProperty).append("\">, ").append("#{item.").append(javaProperty)
                        .append("}</if>\n");
                saveValue2.append("\t\t, #{item.").append(javaProperty).append("}\n");

                updateSQL.append("\t\t<if test=\"null != item.").append(javaProperty).append("\">");
                updateSQL.append(", ").append(columnName).append(" = #{item.").append(javaProperty).append("}</if>\n");
                insertSelectiveValues.append("\t\t<if test=\"null != ").append(javaProperty).append("\"> ").append("#{").append(javaProperty).append(",jdbcType=").append(introspectedColumn.getJdbcTypeName()).append("},</if>\n");
            }
        }
        saveColumn.append("\t</trim>");
        saveColumn2.append("\n\t</trim>");
        insertSelectiveSql.append("\t</trim>");
        saveValue.append("\t</trim>");
        saveValue2.append("\t</trim>");
        insertSelectiveValues.append("\t</trim>");
        updateSQL.append("\t</trim>").append("\n\twhere");

        for (IntrospectedColumn pkColumn : pkColumnList) {
            keySQL.append(" and ").append(pkColumn.getActualColumnName()).append(" = #{item.")
                    .append(pkColumn.getJavaProperty()).append("}");
        }

        rootElement.addElement(createSql("sql_columns", saveColumn2.toString()));
        rootElement.addElement(createSql("sql_values", saveValue2.append("\t").toString()));
        String whereSQL = MessageFormat.format("<where>\n{0}\t</where>", ifSQL.toString());
        rootElement.addElement(createSql("sql_where", whereSQL));
        String keyStr = keySQL.toString().replaceFirst("and", "");
        rootElement.addElement(createSql("sql_update", updateSQL.append(keyStr).toString()));
        rootElement.addElement(createSql("sql_save_columns", saveColumn.append("\t").toString()));
        rootElement.addElement(createSql("sql_save_values", saveValue.append("\t").toString()));

        rootElement.addElement(createSave("batchInsert", pkColumnList.get(0), true));
        rootElement.addElement(createSave("batchInsertSelective", pkColumnList.get(0), false));
        rootElement.addElement(createUpdate("batchUpdateByPrimaryKey"));
        rootElement.addElement(insertSelective("insertSelective",introspectedTable, pkColumnList.get(0), insertSelectiveSql, insertSelectiveValues));
        // 批量删除只支持单主键
        rootElement.addElement(createDels(tableName, pkColumnList.get(0), "batchDeleteByArray", "array"));
        rootElement.addElement(createDels(tableName, pkColumnList.get(0), "batchDeleteByList", "list"));

        //添加getList
        rootElement.addElement(createGetList(introspectedTable));

        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }

    private Element insertSelective(String insertSelective, IntrospectedTable introspectedTable, IntrospectedColumn pkColumn, StringBuilder insertSelectiveSql, StringBuilder insertSelectiveValues) {
        XmlElement save = new XmlElement("insert");
        save.addAttribute(new Attribute("id", insertSelective));
        if(pkColumn.isAutoIncrement()){
            save.addAttribute(new Attribute("keyColumn", pkColumn.getActualColumnName()));
            save.addAttribute(new Attribute("keyProperty", pkColumn.getJavaProperty()));
            save.addAttribute(new Attribute("useGeneratedKeys", "true"));
        }
        save.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
        // 表全字段新增，使用insert into table(a,b,c) values(a1,b1,c1),(a2,b2,c2)
        save.addElement(new TextElement(insertSelectiveSql.append(insertSelectiveValues.toString()).toString()));
        return save;
    }

    /**
     * 公共SQL
     *
     * @param id
     * @param sqlStr
     * @return
     */
    private XmlElement createSql(String id, String sqlStr) {
        XmlElement sql = new XmlElement("sql");
        sql.addAttribute(new Attribute("id", id));
        sql.addElement(new TextElement(sqlStr));
        return sql;
    }

    private XmlElement createGetList(IntrospectedTable introspectedTable) {
        XmlElement select = new XmlElement("select");
        select.addAttribute(new Attribute("id", "getList"));
        select.addAttribute(new Attribute("resultMap", "BaseResultMap"));
        select.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
        String cloumnNames = getColunNames(introspectedTable);
        select.addElement(new TextElement(" select " + cloumnNames + " from " + introspectedTable.getFullyQualifiedTableNameAtRuntime()));
        XmlElement include = new XmlElement("include");
        include.addAttribute(new Attribute("refid", "sql_where"));
        select.addElement(include);
        return select;
    }

    /**
     * 保存
     *
     * @param id
     * @param pkColumn
     * @return
     */
    private XmlElement createSave(String id, IntrospectedColumn pkColumn, Boolean wholeColumn) {
        XmlElement save = new XmlElement("insert");
        save.addAttribute(new Attribute("id", id));
        //save.addAttribute(new Attribute("keyColumn", pkColumn.getActualColumnName()));
        //save.addAttribute(new Attribute("keyProperty", pkColumn.getJavaProperty()));
        //save.addAttribute(new Attribute("useGeneratedKeys", "true"));
        save.addAttribute(new Attribute("parameterType", "java.util.List"));
        // 表全字段新增，使用insert into table(a,b,c) values(a1,b1,c1),(a2,b2,c2)
        if (wholeColumn) {
            StringBuilder saveStr = new StringBuilder(
                    "<include refid=\"sql_columns\" />\n\t")
                    .append("<foreach collection=\"list\" index=\"index\" item=\"item\" open=\"\" separator=\",\" close=\"\">\n\t  ")
                    .append("<include refid=\"sql_values\" />\n\t</foreach>");
            save.addElement(new TextElement(saveStr.toString()));
            // 表字段不定的新增-->同一批次还是要一样的
        } else {
            StringBuilder saveStr = new StringBuilder(
                    "<include refid=\"sql_save_columns\" />\n\t")
                    .append("<foreach collection=\"list\" index=\"index\" item=\"item\" open=\"\" separator=\",\" close=\"\">\n\t  ")
                    .append("<include refid=\"sql_save_values\" />\n\t</foreach>");
            save.addElement(new TextElement(saveStr.toString()));
        }
        return save;
    }

    /**
     * 更新
     *
     * @param id
     * @return
     */
    private XmlElement createUpdate(String id) {
        XmlElement update = new XmlElement("update");
        update.addAttribute(new Attribute("id", id));
        if ("update".equals(id)) {
            update.addElement(new TextElement("<include refid=\"sql_update\" />"));
        } else {
            update.addElement(new TextElement(
                    "<foreach collection=\"list\" index=\"index\" item=\"item\" open=\"\" separator=\";\" close=\"\">\n\t  <include refid=\"sql_update\" />\n\t</foreach>"));
        }
        return update;
    }

    /**
     * 批量删除
     *
     * @param tableName
     * @param pkColumn
     * @param method
     * @param type
     * @return
     */
    private XmlElement createDels(String tableName, IntrospectedColumn pkColumn, String method, String type) {
        XmlElement delete = new XmlElement("delete");
        delete.addAttribute(new Attribute("id", method));
        StringBuilder deleteStr = new StringBuilder("delete from ").append(tableName).append(" where ").append(pkColumn.getActualColumnName())
                .append(" in\n\t")
                .append("<foreach collection=\"").append(type)
                .append("\" index=\"index\" item=\"item\" open=\"(\" separator=\",\" close=\")\">#{item}</foreach>");
        delete.addElement(new TextElement(deleteStr.toString()));
        return delete;
    }
    @Override
    public boolean sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(XmlElement element,
                                                                        IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean sqlMapInsertElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean sqlMapInsertSelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable){
        return  false;
    }

    @Override
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element,
                                                                     IntrospectedTable introspectedTable) {
        // LIMIT5,10; // 检索记录行 6-15
        //		XmlElement isNotNullElement = new XmlElement("if");
        //		isNotNullElement.addAttribute(new Attribute("test", "limitStart != null and limitStart >=0"));
        // isNotNullElement.addElement(new
        // TextElement("limit ${limitStart} , ${limitEnd}"));
        // element.addElement(isNotNullElement);
        // LIMIT 5;//检索前 5个记录行
        return super.sqlMapSelectByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
    }

    private void addSerialVersionUID(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        CommentGenerator commentGenerator = context.getCommentGenerator();
        Field field = new Field();
        field.setVisibility(JavaVisibility.PRIVATE);
        field.setType(new FullyQualifiedJavaType("long"));
        field.setStatic(true);
        field.setFinal(true);
        field.setName("serialVersionUID");
        field.setInitializationString(RandomUtils.nextLong(0L,Long.MAX_VALUE)+ "L");
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);

        FullyQualifiedJavaType serializable = new FullyQualifiedJavaType("Serializable");
        FullyQualifiedJavaType imp = new FullyQualifiedJavaType("java.io.Serializable");

        topLevelClass.addSuperInterface(serializable);
        topLevelClass.addImportedType(imp);

    }

    /**
     * 具体生成toString方法
     *
     * @param introspectedTable
     * @param topLevelClass
     */
    private void generateToString(IntrospectedTable introspectedTable,
                                  TopLevelClass topLevelClass) {
        //首先创建一个Method对象，注意，这个Method是org.mybatis.generator.api.dom.java.Method，
        //这个Method是MBG中对对象DOM的一个抽象；因为我们要添加方法，所以先创建一个；
        Method method = new Method();

        //设置这个方法的可见性为public，代码已经在一步一步构建这个方法了
        method.setVisibility(JavaVisibility.PUBLIC);

        //设置方法的返回类型，这里注意一下的就是，returnType是一个FullyQualifiedJavaType；
        //这个FullyQualifiedJavaType是MGB中对Java中的类型的一个DOM封装，这个类在整个MBG中大量使用；
        //FullyQualifiedJavaType提供了几个静态的方法，比如getStringInstance，就直接返回了一个对String类型的封装；
        method.setReturnType(FullyQualifiedJavaType.getStringInstance());

        //设置方法的名称，至此，方法签名已经装配完成；
        method.setName("toString");

        //判断当前MBG运行的环境是否支持Java5（这里就可以看出来IntrospectedTable类的作用了，主要是查询生成环境的作用）
        if (introspectedTable.isJava5Targeted()) {
            //如果支持Java5，就在方法上面生成一个@Override标签；
            method.addAnnotation("@Override");
        }
        //访问上下文对象（这个context对象是在PluginAdapter初始化完成后，通过setContext方法设置进去的，
        //通过getCommentGenerator方法得到注释生成器，并调用addGeneralMethodComment为当前生成的方法添加注释；
        //因为我们没有提供自己的注释生成器，所以默认的注释生成器只是说明方法是通过MBG生成的，对应的是哪个表而已；
        //这句代码其实非常有意义，通过这句代码，我们基本就可能了解到MBG中对于方法注释的生成方式了；
        context.getCommentGenerator().addGeneralMethodComment(method,
                introspectedTable);

        //OK，调用addBodyLine开始为方法添加代码了
        //可以看到，确实，只是简单的把要生成的代码通过String拼装到了method的body中而已；
        //想到了什么？确实，我想到了Servelt的输出方法。MBG默认的方法体具体的实现，就是像Servlet那样通过String输出的；
        //所以，这才会为我们后面准备用Velocity来重写MBG提供了依据，我们只是给MBG添加一个MVC的概念；
        method.addBodyLine("StringBuilder sb = new StringBuilder();");
        method.addBodyLine("sb.append(getClass().getSimpleName());");
        method.addBodyLine("sb.append(\" [\");");
        method.addBodyLine("sb.append(\"Hash = \").append(hashCode());");

        //接下来要准备拼装类的字段了；
        StringBuilder sb = new StringBuilder();

        //通过topLevelClass得到当前类的所有字段，注意，这里的Field是org.mybatis.generator.api.dom.java.Field
        //这个Field是MBG对字段的一个DOM封装
        for (Field field : topLevelClass.getFields()) {
            //得到字段的名称；
            String property = field.getName();
            //重置StringBuilder；
            sb.setLength(0);

            //添加字段的输出代码；
            sb.append("sb.append(\"").append(", ").append(property)
                    .append("=\")").append(".append(").append(property)
                    .append(");");

            //把这个字段的toString输出到代码中；所以才看到我们最后生成的代码结果中，每一个字段在toString方法中各占一行；
            method.addBodyLine(sb.toString());
        }

        method.addBodyLine("sb.append(\"]\");");
        method.addBodyLine("return sb.toString();");

        //把拼装好的方法DOM添加到topLevelClass中，完成方法添加；
        topLevelClass.addMethod(method);
    }

    public boolean validate(List<String> arg0) {
        return true;
    }

    public static void generate() {
        String config = GenPlugin.class.getClassLoader().getResource("mybatisConfig.xml").getFile();
        String[] arg = {"-configfile", config, "-overwrite"};
        ShellRunner.main(arg);
    }

    public static void main(String[] args) {
        generate();
    }
}