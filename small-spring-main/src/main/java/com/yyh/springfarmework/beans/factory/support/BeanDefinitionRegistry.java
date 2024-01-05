package com.yyh.springfarmework.beans.factory.support;

import com.yyh.springfarmework.beans.factory.config.BeanDefinition;

/**
 * bean注册的接口类
 * @author sora
 */
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    boolean containsBeanDefinition(String beanName);
}
