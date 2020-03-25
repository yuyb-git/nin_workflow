package cn.netinnet.workflow.util;

import java.io.*;

/**
 * @ClassName FileUtil
 * @Description
 * @Author yuyb
 * @Date 2020/3/25 16:00
 */
public class FileUtil {

    /**
     * 读取json文件，返回json串
     * @param fileName
     * @return
     */
    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);

            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 写文件到.Json
     * @param filePath
     * @param jsonStr
     * @throws IOException
     */
    public static void writeFile(String filePath, String jsonStr)
            throws IOException {
        FileWriter fw = new FileWriter(filePath);
        PrintWriter out = new PrintWriter(fw);
        out.write(jsonStr);
        out.println();
        fw.close();
        out.close();
    }

}
