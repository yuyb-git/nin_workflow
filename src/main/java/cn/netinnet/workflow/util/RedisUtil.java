package cn.netinnet.workflow.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	// 维护一个本类的静态变量
	private static RedisUtil redisUtil;

	@PostConstruct
	public void init() {
		redisUtil = this;
		redisUtil.redisTemplate = this.redisTemplate;
	}

	/** 
	 * 指定缓存失效时间 
	 * @param key 键 
	 * @param time 时间(秒) 
	 * @return 
	 */  
	public static boolean expire(String key, long time){  
		try {  
			if(time>0){  
				redisUtil.redisTemplate.expire(key, time, TimeUnit.SECONDS);
			}  
			return true;  
		} catch (Exception e) {  
			e.printStackTrace();  
			return false;  
		}  
	}  

	/** 
	 * 根据key 获取过期时间 
	 * @param key 键 不能为null 
	 * @return 时间(秒) 返回0代表为永久有效 
	 */  
	public static long getExpire(String key){  
		return redisUtil.redisTemplate.getExpire(key,TimeUnit.SECONDS);  
	}  

	/** 
	 * 判断key是否存在 
	 * @param key 键 
	 * @return true 存在 false不存在 
	 */  
	public static boolean hasKey(String key){  
		try {  
			return redisUtil.redisTemplate.hasKey(key);  
		} catch (Exception e) {  
			e.printStackTrace();  
			return false;  
		}  
	}  

	/** 
	 * 删除缓存 
	 * @param key 可以传一个值 或多个 
	 */  
	@SuppressWarnings("unchecked")  
	public static void del(String ... key){  
		if(key!=null&&key.length>0){  
			if(key.length==1){  
				redisUtil.redisTemplate.delete(key[0]);  
			}else{  
				redisUtil.redisTemplate.delete(CollectionUtils.arrayToList(key));  
			}  
		}  
	}
	
	//============================String=============================  
	/** 
	 * 普通缓存获取 
	 * @param key 键 
	 * @return 值 
	 */  
	public static Object get(String key){
		return key==null ? null : redisUtil.redisTemplate.opsForValue().get(key);  
	}  

	/** 
	 * 普通缓存放入 
	 * @param key 键 
	 * @param value 值 
	 * @return true成功 false失败 
	 */  
	public static boolean set(String key, Object value) {  
		try {  
			redisUtil.redisTemplate.opsForValue().set(key, value);  
			return true;  
		} catch (Exception e) {  
			e.printStackTrace();  
			return false;  
		}  

	}  

	/** 
	 * 普通缓存放入并设置时间 
	 * @param key 键 
	 * @param value 值 
	 * @param time 时间(秒) time要大于0 如果time小于等于0 将设置无限期 
	 * @return true成功 false 失败 
	 */  
	public static boolean set(String key, Object value, long time){  
		try {  
			if(time>0){  
				redisUtil.redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);  
			}else{  
				set(key, value);  
			}  
			return true;  
		} catch (Exception e) {  
			e.printStackTrace();  
			return false;  
		}  
	}

	//================================Map=================================  
	/** 
	 * HashGet 获取key的结果Map<Object,Object>里key为item的value
	 * @param key 键 不能为null 
	 * @param item 项 不能为null 
	 * @return 值 
	 */  
	public static Object mapGet(String key, String item){  
		return redisUtil.redisTemplate.opsForHash().get(key, item);  
	}  

	/** 
	 * 获取hashKey对应的所有键值 
	 * @param key 键 
	 * @return 对应的多个键值 
	 */  
	public static Map<Object,Object> mapGet(String key){  
		return redisUtil.redisTemplate.opsForHash().entries(key);  
	}  

	/** 
	 * HashSet 
	 * @param key 键 
	 * @param map 对应多个键值 
	 * @return true 成功 false 失败 
	 */  
	public static boolean mapSet(String key, Map<String,Object> map){    
		try {  
			redisUtil.redisTemplate.opsForHash().putAll(key, map);  
			return true;  
		} catch (Exception e) {  
			e.printStackTrace();  
			return false;  
		}  
	}  

	/** 
	 * HashSet 并设置时间 
	 * @param key 键 
	 * @param map 对应多个键值 
	 * @param time 时间(秒) 
	 * @return true成功 false失败 
	 */  
	public static boolean mapSet(String key, Map<String,Object> map, long time){    
		try {  
			redisUtil.redisTemplate.opsForHash().putAll(key, map);  
			if(time>0){  
				expire(key, time);  
			}  
			return true;  
		} catch (Exception e) {  
			e.printStackTrace();  
			return false;  
		}  
	}  

	/** 
	 * 向一张hash表中放入数据,如果不存在将创建 
	 * @param key 键 
	 * @param item 项 
	 * @param value 值 
	 * @return true 成功 false失败 
	 */  
	public static boolean mapSet(String key, String item, Object value) {  
		try {  
			redisUtil.redisTemplate.opsForHash().put(key, item, value);  
			return true;  
		} catch (Exception e) {  
			e.printStackTrace();  
			return false;  
		}  
	}  

	/** 
	 * 向一张hash表中放入数据,如果不存在将创建 
	 * @param key 键 
	 * @param item 项 
	 * @param value 值 
	 * @param time 时间(秒)  注意:如果已存在的hash表有时间,这里将会替换原有的时间 
	 * @return true 成功 false失败 
	 */  
	public static boolean mapSet(String key, String item, Object value, long time) {  
		try {  
			redisUtil.redisTemplate.opsForHash().put(key, item, value);  
			if(time>0){  
				expire(key, time);  
			}  
			return true;  
		} catch (Exception e) {  
			e.printStackTrace();  
			return false;  
		}  
	}  

	/** 
	 * 删除hash表中的值 
	 * @param key 键 不能为null 
	 * @param item 项 可以使多个 不能为null 
	 */  
	public static void mapDel(String key, Object... item){    
		redisUtil.redisTemplate.opsForHash().delete(key,item);  
	}   

	/** 
	 * 判断hash表中是否有该项的值 
	 * @param key 键 不能为null 
	 * @param item 项 不能为null 
	 * @return true 存在 false不存在 
	 */  
	public static boolean mapHasKey(String key, String item){  
		return redisUtil.redisTemplate.opsForHash().hasKey(key, item);  
	} 
	
	//===============================list================================= 
	
	/** 
     * 获取list缓存的内容 
     * @param key 键
     * @param start 开始 
     * @param end 结束  0 到 -1代表所有值 
     * @return 
     */  
    public static List<Object> listGet(String key,long start, long end){  
        try {  
            return redisUtil.redisTemplate.opsForList().range(key, start, end);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
	
	 /** 
     * 通过索引 获取list中的值 
     * @param key 键 
     * @param index 索引  index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推 
     * @return 
     */  
    public static Object listGetIndex(String key, long index){  
        try {  
            return redisUtil.redisTemplate.opsForList().index(key, index);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
      
    /** 
     * 将list放入缓存 
     * @param key 键 
     * @param value 值 
     * @return
     */  
    public static boolean listSet(String key, Object value) {  
        try {  
            redisUtil.redisTemplate.opsForList().rightPush(key, value);  
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  
    }  
      
    /** 
     * 将list放入缓存 
     * @param key 键 
     * @param value 值 
     * @param time 时间(秒) 
     * @return 
     */  
    public static boolean listSet(String key, Object value, long time) {  
        try {  
            redisUtil.redisTemplate.opsForList().rightPush(key, value);  
            if (time > 0) {
				expire(key, time);
			}
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  
    }  
      
    /** 
     * 将list放入缓存 
     * @param key 键 
     * @param value 值 
     * @return
     */  
    public static boolean listSet(String key, List<Object> value) {  
        try {  
            redisUtil.redisTemplate.opsForList().rightPushAll(key, value);  
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  
    }  
      
    /** 
     * 将list放入缓存 
     * @param key 键 
     * @param value 值 
     * @param time 时间(秒) 
     * @return 
     */  
    public static boolean listSet(String key, List<Object> value, long time) {  
        try {  
            redisUtil.redisTemplate.opsForList().rightPushAll(key, value);  
            if (time > 0) {
				expire(key, time);
			}
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  
    }
    
    /** 
     * 根据索引修改list中的某条数据 
     * @param key 键 
     * @param index 索引 
     * @param value 值 
     * @return 
     */  
    public static boolean listUpdateIndex(String key, long index, Object value) {  
        try {  
            redisUtil.redisTemplate.opsForList().set(key, index, value);  
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  
    }

	/**
	 * @Description 通过前缀删除缓存，注意：删除的前缀应该是就近一级 eg:  key=test:aa:bb:12345 那么他的前缀应该是test:aa:bb:*
	 * @Param  prefix
	 * @return boolean
	 * @Author osp
	 * @Date 2019/7/9
	 **/
	public static boolean delByPrefix(String prefix) {
		try {
			redisUtil.redisTemplate.delete(redisUtil.redisTemplate.keys(prefix));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @Description	获取所有满足pattern的key
	 * @Param  pattern
	 * @return java.util.Set<java.lang.String>
	 * @Author osp
	 * @Date 2019/8/30
	 **/
	public static Set<String> keys(String pattern) {
		return redisUtil.redisTemplate.keys(pattern);
	}

	/**
	* @Param keys
	* @description  删除缓存
	* @author ousp
	* @date 2020/2/12
	* @return boolean
	*/
	public static boolean del(Set<String> keys) {
		try {
			redisUtil.redisTemplate.delete(keys);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
