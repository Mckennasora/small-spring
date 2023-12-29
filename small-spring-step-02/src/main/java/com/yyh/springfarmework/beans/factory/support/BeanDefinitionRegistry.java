package com.yyh.springfarmework.beans.factory.support;

import com.yyh.springfarmework.beans.factory.config.BeanDefinition;

/**
 * @author sora
 * @description
 */
public interface BeanDefinitionRegistry {
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
