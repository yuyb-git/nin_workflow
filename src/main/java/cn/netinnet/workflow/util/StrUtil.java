package cn.netinnet.workflow.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrUtil {
	
	private static Pattern linePattern = Pattern.compile("_(\\w)");
	
	/** 下划线转驼峰 */
	public static String lineToHump(String str) {
		str = str.toLowerCase();
		Matcher matcher = linePattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
		}
		matcher.appendTail(sb);
		return sb.toString();
	}
	
    /**
     * 如果是null,直接返回空字符串
     *
     * @param str
     * @return
     */
    public static String str2Html(Object str) {
        if (str == null) {
			return "";
		}
        return (String) str;
    }

    /**
     * 根据数据获取对应的英文字母
     *
     * @param numO 字符串
     * @return
     */
    public static String getEngCodeFromNum(Object numO) {
        if (numO == null) {
			return "";
		}
        String[] code = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N"};
        int num = null2Int(numO, 1) - 1;
        if (num > (code.length - 1)) {
			num = 0;
		}
        return code[num];
    }

    /**
     * 根据数据获取多个以指定符号隔开的数字所对应的英文字母
     *
     * @param numO            字符串
     * @param splitStr        多个数字的分隔符
     * @param replaceSplicStr 分隔符要替换成什么新的字符,null不替换
     * @return
     */
    public static String getEngCodeFromNumBatch(Object numO, String splitStr, String replaceSplicStr) {
        if (numO == null) {
			return "";
		}
        String numStr = String.valueOf(numO);
        String[] numStrs = numStr.split(splitStr);
        int len = numStrs.length;
        StringBuilder newNumStrs = new StringBuilder("");
        if (replaceSplicStr == null)
            replaceSplicStr = splitStr;
        for (int i = 0; i < len; i++) {
            newNumStrs.append(i == 0 ? "" : replaceSplicStr).append(getEngCodeFromNum(numStrs[i]));
        }
        return newNumStrs.toString();
    }

    /**
     *
     * 根据数据获取多个以指定符号隔开的数字所对应的英文字母,并分别为交集(这里是指在numO1的字段在numO2中能找到)和差集(这里是指在numO1的字段在numO2中不能找到)体指定前前缀和后缀
     *
     * @param numO1           主字符串1
     * @param numO2           字符串2
     * @param splitStr        多个数字的分隔符
     * @param intersectionPre 交集前缀
     * @param intersectionSuf 交集后缀
     * @param differencePre   差集前缀
     * @param differenceSuf   差集后缀
     * @return
     */
    public static String getEngCodeFromNumBatch(Object numO1, Object numO2, String splitStr, String replaceSplicStr, String intersectionPre, String intersectionSuf,
                                                String differencePre, String differenceSuf) {
        if (numO2 == null) {
			return "";
		}
        String numStr = String.valueOf(numO1);
        String numStr2 = String.valueOf(numO2);
        String[] numStrs = numStr.split(splitStr);
        String[] numStrs2 = numStr2.split(splitStr);
        int len = numStrs.length;
        int len2 = numStrs2.length;
        int j;
        boolean exist = false;
        String num = null, num2 = null;
        StringBuilder newNumStrs = new StringBuilder("");

        if (replaceSplicStr == null) {
			replaceSplicStr = splitStr;
		}
        for (int i = 0; i < len; i++) {
            num = numStrs[i];
            num = num == null ? "" : num.trim();
            for (j = 0; j < len2; j++) {
                num2 = numStrs2[j];
                num2 = num2 == null ? "" : num2.trim();
                if (num.equals(num2)) {
                    exist = true;
                    break;
                }
            }
            if (exist) {
				newNumStrs.append(i == 0 ? "" : replaceSplicStr).append(intersectionPre).append(getEngCodeFromNum(num)).append(intersectionSuf);
			} else {
				newNumStrs.append(i == 0 ? "" : replaceSplicStr).append(differencePre).append(getEngCodeFromNum(num)).append(differenceSuf);
			}
        }
        return newNumStrs.toString();
    }

    /**
     * 将对象转换成int
     *
     * @param numO
     * @param defaultVal:null或转换失败后的默认值
     * @return
     */
    public static int null2Int(Object numO, int defaultVal) {
        if (numO == null) {
			return defaultVal;
		}
        try {
            return Integer.parseInt(String.valueOf(numO));
        } catch (Exception e) {
            return defaultVal;
        }
    }
    
    public static BigDecimal null2BigDecimal(Object val, BigDecimal defaultVal){
    	if (val == null) {
			return defaultVal;
		}
        try {
            return new BigDecimal(String.valueOf(val));
        } catch (Exception e) {
            return defaultVal;
        }
    }
    public static BigDecimal null2BigDecimal(Object val){
    	return null2BigDecimal(val, BigDecimal.ZERO);
    }

    /**
     * 将对象转换成long
     *
     * @param numO
     * @param defaultVal:null或转换失败后的默认值
     * @return
     */
    public static long null2Long(Object numO, long defaultVal) {
        if (numO == null) {
			return defaultVal;
		}
        try {
            return Long.parseLong(String.valueOf(numO));
        } catch (Exception e) {
            return defaultVal;
        }
    }

    /**
     * 将对象转换成double
     *
     * @param numO
     * @param defaultVal:null或转换失败后的默认值
     * @return
     */
    public static double null2Double(Object numO, double defaultVal) {
        if (numO == null) {
			return defaultVal;
		}
        try {
            return Double.parseDouble(String.valueOf(numO));
        } catch (Exception e) {
            return defaultVal;
        }
    }

	/** 方法描述
	 * @description  对象转化为String[]
	 * @param obj
	 * @return java.lang.String[]
	 * @author Caicm
	 * @date 2018/9/29 14:19
	 */
	public static String[] ObjectToStringArray(Object obj){
		List<String> list = (ArrayList<String>)obj;
		int size = list.size();
		String [] result = (String[])list.toArray(new String[size]);
		return result;
	}

    //格式化以逗号隔开的字符串为带单引号的以逗号隔开的字符串
    public static String formatStrs(String str) {
        if (str == null) {
			return "";
		}
        String []strs = str.split(",");
        StringBuilder newStr = new StringBuilder("");
        for (String tmpStr : strs) {
            newStr.append(",'").append(tmpStr).append("'");
        }
        return newStr.toString().replaceFirst(",", "");
    }

    /**
     * 获取文件的扩展名
     *
     * @param fileUrl
     * @return
     */
    public static String getFileType(String fileUrl) {
        if (fileUrl == null || "".equals(fileUrl.trim())) {
			return "";
		}
        int lastPointIndex = fileUrl.lastIndexOf(".");
        if (lastPointIndex == -1 || lastPointIndex == (fileUrl.length() - 1)) {
			return "";
		}
        return fileUrl.substring(lastPointIndex + 1);
    }

    /**
     * formatNum(格式化数字)
     *
     * @param num：要被格式化的数字
     * @param places：总位数数字
     * @return String 返回类型
     */
    public static String formatNum(Integer num, int places) {
        //数字长度为5位，长度不够数字前面补0
        String newStrNum = String.format("%0" + places + "d", num);
        return newStrNum;
    }

    /**
     * 去掉多余的.与0
     * @param s
     * @return
     */
    public static String subZeroAndDot(String s){
        if(s.indexOf(".") > 0){
			//去掉多余的0
            s = s.replaceAll("0+?$", "");
			//如最后一位是.则去掉
            s = s.replaceAll("[.]$", "");
        }
        return s;
    }
    
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#0.00");
    
    /**
	 * 字符串转BigDecimal,
	 * 失败则返回设置的默认值 BigDecimal.ZERO (0)
	 * */
	public static BigDecimal strToBigDecimal(String val) {
		return strToBigDecimal(val, BigDecimal.ZERO);
	}
    
    /**
	 * 字符串转BigDecimal,
	 * 失败则返回设置的默认值 @param defaultVal
	 * */
	public static BigDecimal strToBigDecimal(String val, BigDecimal defaultVal) {
		BigDecimal convertedVal = defaultVal;
		try {
			convertedVal = new BigDecimal(val.trim());
		} catch (Exception e) {
		}
		return null == convertedVal ? convertedVal : new BigDecimal(DECIMAL_FORMAT.format(convertedVal));
	}
	
	/**
	 * 加法运算
	 * */
	public static String addAcc(String op1, String op2) {
		String rs = "";
		try {
			if ((null == op1 || "".equals(op1)) && (null == op2 || "".equals(op2))) {
				return "";
			}
			op1 = null == op1 || "".equals(op1) ? "0" : op1;
			op2 = null == op2 || "".equals(op2) ? "0" : op2;
			rs = String.valueOf(new BigDecimal(op1).add(new BigDecimal(op2)));
		} catch (Exception e) {
		}
		return rs;
	}

	public static String addAcc(Object op1, Object op2) {
		return addAcc(String.valueOf(op1), String.valueOf(op2));
	}
	
	
	public static String addAcc(Object[] ops) {
		String sum = "0";
		for(Object op : ops) {
			sum = addAcc(sum, op);
		}
		return sum;
	}

	/**
	 * 减法运算
	 * */
	public static String subAcc(String op1, String op2) {
		String rs = "";
		try {
			if ((null == op1 || "".equals(op1)) && (null == op2 || "".equals(op2))) {
				return "";
			}
			op1 = null == op1 || "".equals(op1) ? "0" : op1;
			op2 = null == op2 || "".equals(op2) ? "0" : op2;
			rs = String.valueOf(new BigDecimal(op1).subtract(new BigDecimal(op2)));
		} catch (Exception e) {
		}
		return rs;
	}
	
	public static String subAcc(Object op1, Object op2) {
		return subAcc(String.valueOf(op1), String.valueOf(op2));
	}

	/**
	 * 乘法运算
	 * */
	public static String mulAcc(String op1, String op2) {
		String rs = "";
		try {
			if ((null == op1 || "".equals(op1)) && (null == op2 || "".equals(op2))) {
				return "";
			}
			op1 = null == op1 || "".equals(op1) ? "0" : op1;
			op2 = null == op2 || "".equals(op2) ? "0" : op2;
			rs = String.valueOf(new BigDecimal(op1).multiply(new BigDecimal(op2)));
		} catch (Exception e) {
		}
		return rs;
	}

	public static String mulAcc(Object op1, Object op2) {
		String rs = "";
		try {
			rs = mulAcc(String.valueOf(op1), String.valueOf(op2));
		} catch(Exception e) {}
		return rs;
	}
	
	
	/**
	 * 除法预算
	 * */
	public static String divAcc(String op1, String op2) {
		String rs = "";
		try {
			if ((null == op1 || "".equals(op1)) && (null == op2 || "".equals(op2))) {
				return "";
			} else if ((null == op2 || "".equals(op2)) || (null == op1 || "".equals(op1))) {
				return "0";
			}
			rs = String.valueOf(new BigDecimal(op1).divide(new BigDecimal(op2), 16, BigDecimal.ROUND_HALF_EVEN));
		} catch (Exception e) {
		}
		return rs;
	}
	
	public static String divAcc(Object op1, Object op2) {
		return divAcc(String.valueOf(op1), String.valueOf(op2));
	}
	
	/** 运算结果保留小数位 */
	private static final int CALC_RESULT_SCALE = 2;
	
	/**
	 * 格式化数值(保留2位小数)
	 * */
	public static String formatNumerical(String numVal) {
		String rs = "";
		BigDecimal bd = null;
		try {
			bd = new BigDecimal(numVal);
			bd = bd.divide(new BigDecimal(1), CALC_RESULT_SCALE, RoundingMode.HALF_UP);
		} catch(Exception e) {}
		if(null != bd) {
			rs = String.valueOf(bd);
		}
		return rs;
	}

	public static String formatNumerical(Object numVal) {
		return formatNumerical(String.valueOf(numVal));
	}
	
	/**
	 * 对比中,允许的误差范围
	 * 公式: 标准值 * 相对误差 + 绝对误差
	 * @param standardVal 标准值
	 * @param relativeError
	 * @param absoluteError
	 * */
	public static BigDecimal deviation(BigDecimal standardVal, BigDecimal relativeError, BigDecimal absoluteError) {
		return standardVal.multiply(relativeError).add(absoluteError);
	}
	
	/**
	 * 比较2个BigDecimal在误差允许范围内是否相等
	 * 相等(即: |op1 - op2| <= |deviation|)返回: true
	 * 不相等返回: false
	 * @param op1 待比较的BigDecimal
	 * @param op2 待比较的BigDecimal
	 * @param deviation 允许的误差
	 * */
	public static boolean isEqual(BigDecimal op1, BigDecimal op2, BigDecimal deviation) {
		BigDecimal dValue = op1.subtract(op2);
		dValue = dValue.abs();
		deviation = deviation.abs();
		return dValue.compareTo(deviation) <= 0;
	}
	
	/**
	 * 比较2个BigDecimal在误差允许范围内是否相等
	 * 允许误差: BigDecimal.ZERO (0)
	 * 相等(即: |op1 - op2| <= |deviation|)返回: true
	 * 不相等返回: false
	 * @param op1 待比较的BigDecimal
	 * @param op2 待比较的BigDecimal
	 * */
	public static boolean isEqual(BigDecimal op1, BigDecimal op2) {
		return isEqual(op1, op2, BigDecimal.ZERO);
	}
	
	//将空转换成0
	public static String null2Zero(String par1) {
		if (par1 == null || par1.length() == 0) {
			return "0";
		} else {
			return par1;
		}
	}

	public static List<Map<String, Object>> mergeListToOne(List<Map<String, Object>>[] list){
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		for(List<Map<String, Object>> mapList : list){
			if(mapList != null && mapList.size() > 0){
				for(Map<String, Object> map : mapList){
					result.add(map);
				}
			}
		}
		return result;
	}

	/**
	 * @Description 是否为数值
	 * @Param  str
	 * @return boolean 
	 * @Author osp
	 * @Date 2019/4/15
	 **/
	public static boolean isNumber(String str){
		String reg = "^[0-9]+(.[0-9]+)?$";
		return str.matches(reg);
	}

}
