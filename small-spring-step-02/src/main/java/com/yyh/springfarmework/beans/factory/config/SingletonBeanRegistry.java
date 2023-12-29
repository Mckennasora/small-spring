package com.yyh.springfarmework.beans.factory.config;

/**
 * 定义了一个获取单例对象的接口
 * @author sora
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
