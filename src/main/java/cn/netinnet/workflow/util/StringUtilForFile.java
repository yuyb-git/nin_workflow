package cn.netinnet.workflow.util;

import cn.netinnet.common.util.StringUtil;
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.util.ClassUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Copyright ©厦门网中网软件有限公司.
 *
 * @author here
 * @version 1.0
 * @description 文件相关的字符操作工具类
 * @date 2019/4/26 10:27
 */
public class StringUtilForFile {
    //斜杠
    public final static String SLASH = "/";
    //反斜杠
    public final static String BACKSLASH = "\\\\";
    //换行
    public static final String LINE_SEPARATOR = "\n";

    /** 方法描述
     * @description 获取文件扩展名(不包含.)
     * @param fileName 文件名或文件路径
     * @return java.lang.String
     * @author here
     * @date 2019/4/26 10:16
     */
    static String getFileExtendName(String fileName){
        if ((fileName == null) || ("".equals(fileName))) {
            return "";
        }
        int idx = fileName.lastIndexOf(".");
        if (idx < 0) {
            return "";
        }
        return fileName.substring(idx);
    }

    /** 方法描述
     * @description 获取文件名（不带后缀）
     * @param fileName 文件名
     * @return java.lang.String
     * @author here
     * @date 2019/4/26 10:17
     */
    static String getNameExcludeExtendName(String fileName) {
        if ((fileName == null) || ("".equals(fileName))) {
            return "";
        }
        int idx = fileName.lastIndexOf(".");
        if (idx < 0) {
            return "";
        }
        return fileName.substring(0, idx);
    }

    /** 方法描述
     * @description 替换路径上的所有反斜杠为斜杠
     * @param dir 要被替换的文件路径
     * @param endWithSlash 是否以斜杠结束, 如果是, 将在末尾添加斜杠
     * @param defaultVal 默认值,  当dir为null或为全空字符串时,要设置的默认值
     * @return java.lang.String
     * @author here
     * @date 2019/4/26 11:35
     */
    public static String replaceAllBackslashs(String dir, boolean endWithSlash, String defaultVal) {
        if(StringUtil.isBlankOrNull(dir)) {
            dir = defaultVal;
        } else {
            dir.replaceAll(BACKSLASH, SLASH);

            //如果不是以斜杠结尾,则自动加上斜杠
            if (endWithSlash && !dir.endsWith(SLASH)) {
                dir += SLASH;
            }
        }
        return dir;
    }

    /**
     * @Description 判断是否为绝对路径
     * @Param  path
     * @return boolean
     * @Author osp
     * @Date 2019/4/27
     **/
    public static boolean isAbsolutePath(String path) {
        if (path.startsWith("/") || path.indexOf(":") > 0) {
            return true;
        }
        return false;
    }

    public static void outputXml(Document doc, String filename){
        OutputFormat format = OutputFormat.createPrettyPrint();
        /** 指定XML编码 */
        format.setEncoding("UTF-8");
        /** 将document中的内容写入文件中 */
        XMLWriter writer;
        try {
            writer = new XMLWriter(new FileWriter(new File(filename)), format);
            writer.write(doc);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getAbsolutePath(String path) {
        if (path.contains(":")) {
            return path;
        }
        return ClassUtils.getDefaultClassLoader().getResource("").getPath() + path;
    }

}
