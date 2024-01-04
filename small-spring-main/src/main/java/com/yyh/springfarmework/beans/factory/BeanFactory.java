package com.yyh.springfarmework.beans.factory;

import com.yyh.springfarmework.beans.BeansException;

/**
 * Bean工厂接口，提供getBean规范
 *
 * @author sora
 */
public interface BeanFactory {
    Object getBean(String name) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType);

    Object getBean(String name, Object... args) throws BeansException;
}
