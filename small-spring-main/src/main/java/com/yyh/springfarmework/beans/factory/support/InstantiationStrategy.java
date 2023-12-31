package com.yyh.springfarmework.beans.factory.support;

import com.yyh.springfarmework.beans.BeansException;
import com.yyh.springfarmework.beans.core.io.Resource;
import com.yyh.springfarmework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例化策略接口
 * @author sora
 */
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
