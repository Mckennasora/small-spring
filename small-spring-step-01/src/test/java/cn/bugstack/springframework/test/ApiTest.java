package cn.bugstack.springframework.test;

import cn.bugstack.springframework.test.bean.UserService;
import com.yyh.springframework.BeanDefinition;
import com.yyh.springframework.BeanFactory;
import org.junit.jupiter.api.Test;

/**
 * @author sora
 * @description
 */
public class ApiTest {
    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        BeanFactory beanFactory = new BeanFactory();
        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 3.获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

}
