package com.yyh.springfarmework.beans.factory.support;

import com.yyh.springfarmework.beans.BeansException;
import com.yyh.springfarmework.beans.core.io.Resource;
import com.yyh.springfarmework.beans.core.io.ResourceLoader;

public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;
}