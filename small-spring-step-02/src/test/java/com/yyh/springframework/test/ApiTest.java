package com.yyh.springframework.test;

import com.yyh.springfarmework.beans.factory.config.BeanDefinition;
import com.yyh.springfarmework.beans.factory.support.DefaultListableBeanFactory;
import com.yyh.springframework.test.bean.UserService;
import org.junit.jupiter.api.Test;

/**
 * @author sora
 * @description
 */
class ApiTest {
    @Test
    void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 3.第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
        // 4.第二次获取 bean from Singleton
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();
    }
}
