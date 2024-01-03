package com.yyh.springframework.test;


import com.yyh.springfarmework.beans.PropertyValue;
import com.yyh.springfarmework.beans.PropertyValues;
import com.yyh.springfarmework.beans.factory.config.BeanDefinition;
import com.yyh.springfarmework.beans.factory.config.BeanReference;
import com.yyh.springfarmework.beans.factory.support.DefaultListableBeanFactory;
import com.yyh.springframework.test.bean.UserDao;
import com.yyh.springframework.test.bean.UserService;
import org.junit.jupiter.api.Test;

/**
 * @author sora
 */
class ApiTest {
    @Test
    void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2. UserDao 注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));
        // 3. UserService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // 4. UserService 注册
        beanFactory.registerBeanDefinition("userService", new BeanDefinition(UserService.class, propertyValues));

        // 5. UserService 获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
