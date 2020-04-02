package cn.netinnet.workflow.util;


import com.alibaba.fastjson.JSONObject;
import org.springframework.util.ClassUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @description： 公共的工具类   
 * @company：netinnet  
 * @author：yuyb  
 * @createtime：2019年3月25日 下午2:57:31  
 * @version：V1.0
 */
public class CommonUtil {
	
	public static boolean isAbsolutePath(String path) {
		if (path.startsWith(File.separator) || path.indexOf(":") > 0) {
			return true;
		}
		return false;
	}

	public static String getAbsolutePath(String path) {
		if (path.indexOf(":") > 0) {
			return path;
		}
		return ClassUtils.getDefaultClassLoader().getResource("").getPath() + path;
	}

    public static boolean isIE(HttpServletRequest request) {
        String userAgent = request.getHeader("USER-AGENT").toLowerCase();
        // IE7-10 || IE11
        return (userAgent.indexOf("msie") > 0 || (userAgent.indexOf("gecko") > 0 && userAgent.indexOf("rv:11") > 0));
    }


    
    /**
     * @Description 计算本期合计
     * @Param details
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     * @Author osp
     * @Date 2019/5/5
     **/
    public static List<Map<String, Object>> calculateBQHJ(List<Map<String, Object>> details){
        List<Map<String, Object>> codeList = new LinkedList<>();
        Map<String, Integer> kjkmIndexMap= new HashMap<>();
        for (int z = 0, len = details.size(); z < len; z ++) {
            Map<String, Object> map = details.get(z);
            String kjkmCode = map.get("kjkm_code").toString();
            BigDecimal lend = StrUtil.null2BigDecimal(map.get("lend"));
            BigDecimal debit = StrUtil.null2BigDecimal(map.get("debit"));
            if (kjkmIndexMap.get(kjkmCode) != null) {
                int index = kjkmIndexMap.get(kjkmCode);
                Map<String, Object> bqhjMap = codeList.get(index);
                BigDecimal bqhjDebit = StrUtil.null2BigDecimal(bqhjMap.get("debit"));
                bqhjMap.put("debit", bqhjDebit.add(debit).subtract(lend));
            } else {
                Map<String, Object> bqhjMap = new HashMap<>();
                bqhjMap.put("kjkm_code", kjkmCode);
                bqhjMap.put("debit", debit.subtract(lend));
                bqhjMap.put("balance_direct", map.get("balance_direct"));
                kjkmIndexMap.put(kjkmCode, codeList.size());
                codeList.add(bqhjMap);
            }
        }
        return codeList;
    }
    

    
    /**
     * 
     * @description 解析表达式 @@
     * @date 2019年12月30日上午9:37:47
     * @author yuyb    
     * @param expression
     * @param ocrJson
     * @return String
     */
    public static String resolving(String expression, JSONObject ocrJson){
    	if(expression.contains("@@")){
    		int group = (expression.length() - expression.replace("@@", "").length())/4;
    		String itemVariable = null;
    		for(int i = 0; i < group; i ++){
    			int firstIndex = expression.indexOf("@@");
                int lastIndex = expression.indexOf("@@", firstIndex+1);
                //截取第一对@@ @@中间的公式
                itemVariable = expression.substring(firstIndex+2, lastIndex);
                if("当前企业名称".equals(itemVariable)){
                	expression = expression.replace("@@"+itemVariable+"@@", ocrJson.getString("fsscCompanyName"));
                }else if(ocrJson.containsKey(itemVariable)){
                	expression = expression.replaceFirst("@@"+itemVariable+"@@", ocrJson.get(itemVariable).toString());
                }else{
                	expression = expression.replaceFirst("@@"+itemVariable+"@@", "");
                }
    		}
    	}
    	return expression;
    }
    
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

	/** 方法描述
	 * @description 对象序列化
	 * @param obj
	 * @return [obj]
	 * @author wanghy
	 * @date 2020/2/28 14:09
	 */
	public static byte[] ObjectToByte(Object obj) {
		byte[] bytes = null;
		try {
			ByteArrayOutputStream bo = new ByteArrayOutputStream();
			ObjectOutputStream oo = new ObjectOutputStream(bo);
			oo.writeObject(obj);
			bytes = bo.toByteArray();
			bo.close();
			oo.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return bytes;
	}

	/** 方法描述
	 * @description 反序列化
	 * @param bytes
	 * @return [bytes]
	 * @author wanghy
	 * @date 2020/2/28 14:10
	 */
	public static Object ByteToObject(byte[] bytes) {
		Object object = null;
		try {
			ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			object = ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}
    
}
