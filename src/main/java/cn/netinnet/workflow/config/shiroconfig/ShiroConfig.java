package cn.netinnet.workflow.config.shiroconfig;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.filter.DelegatingFilterProxy;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Copyright © 厦门网中网软件有限公司.
 *
 * @author wanghy
 * @version 1.0
 * @description shiro配置
 * @date 2020/2/24 14:25
 */
@Configuration
public class ShiroConfig {
    private RedisTemplate<byte[], byte[]> redisTemplate;

    private static final String CACHE_KEY = "shiro:cache:";
    private static final String SESSION_KEY = "shiro:session:";
    private static final String NAME = "custom.name";
    private static final String VALUE = "/";


    @Bean
    public ShiroFilterFactoryBean shiroFilter (SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/login", "anon");

        filterChainDefinitionMap.put("/fsscAdminRole/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean("securityManagers")
    public SecurityManager securityManager () {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRememberMeManager(rememberMeManager());
        defaultWebSecurityManager.setCacheManager(cacheManager());
        defaultWebSecurityManager.setRealm(myShiroRealm());
        defaultWebSecurityManager.setSessionManager(sessionManager());
        return defaultWebSecurityManager;
    }

    private ShiroRedisCacheManager cacheManager () {
        return new ShiroRedisCacheManager(redisTemplate);
    }

    /** 方法描述
     * @description 自定义权限域
     * @return []
     * @author wanghy
     * @date 2020/2/24 14:58
     */
    @Bean
    public ShiroRealm myShiroRealm () {
        ShiroRealm realm = new ShiroRealm();
        realm.setCacheManager(redisCacheManager());
        return realm;
    }

    // 开启注解的权限验证
    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /** 方法描述
     * @description 注解模式
     * @return []
     * @author wanghy
     * @date 2020/3/2 10:20
     */
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor () {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
        return authorizationAttributeSourceAdvisor;
    }


    private SimpleCookie rememberMeCookie () {
        SimpleCookie cookie = new SimpleCookie(CookieRememberMeManager.DEFAULT_REMEMBER_ME_COOKIE_NAME);
        cookie.setSecure(false);
        cookie.setMaxAge(10000);
        return cookie;
    }

    private CookieRememberMeManager rememberMeManager () {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        cookieRememberMeManager.setCipherKey(Base64.decode("ZWvohmPdUsAWT3=KpPqda"));
        return cookieRememberMeManager;
    }

    /** 方法描述
     * @description 配置thymeleaf的shiro启用
     * @return []
     * @author wanghy
     * @date 2020/2/28 14:57
     */
    @Bean
    public ShiroDialect shiroDialect () {
        return new ShiroDialect();
    }

    private DefaultWebSessionManager sessionManager () {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(1000000);
        sessionManager.setSessionIdCookieEnabled(true);
        sessionManager.setSessionIdCookie(simpleCookie());
        sessionManager.setSessionDAO(redisSessionDAO());
        return sessionManager;
    }

    @Bean("delegatingFilterProxy")
    public FilterRegistrationBean delegatingFilterProxy () {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        DelegatingFilterProxy proxy = new DelegatingFilterProxy();
        proxy.setTargetFilterLifecycle(true);
        proxy.setTargetBeanName("shiroFilter");
        filterRegistrationBean.setFilter(proxy);
        return filterRegistrationBean;
    }

    @Bean
    public RedisManager redisManager () {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost("localhost:6379");
        return redisManager;
    }

    @Bean
    public RedisCacheManager redisCacheManager () {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        redisCacheManager.setExpire(86400);
        redisCacheManager.setKeyPrefix(CACHE_KEY);
        return redisCacheManager;
    }

    @Bean
    public RedisSessionDAO redisSessionDAO () {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setExpire(86400);
        redisSessionDAO.setKeyPrefix(SESSION_KEY);
        redisSessionDAO.setRedisManager(redisManager());
        return redisSessionDAO;
    }

    @Bean
    public SimpleCookie simpleCookie () {
        SimpleCookie simpleCookie = new SimpleCookie();
        simpleCookie.setName(NAME);
        simpleCookie.setValue(VALUE);
        return simpleCookie;
    }
}
