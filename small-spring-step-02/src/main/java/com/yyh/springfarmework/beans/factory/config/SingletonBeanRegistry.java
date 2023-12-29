package com.yyh.springfarmework.beans.factory.config;

public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
