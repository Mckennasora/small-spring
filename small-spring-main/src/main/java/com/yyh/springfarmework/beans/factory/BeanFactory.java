package com.yyh.springfarmework.beans.factory;

import com.yyh.springfarmework.beans.BeansException;

/**
 * Bean工厂接口，提供getBean规范
 * @author sora
 */
public interface BeanFactory {
    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... arg) throws BeansException;
}
