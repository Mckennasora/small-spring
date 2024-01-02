package com.yyh.springfarmework.beans.factory;

import com.yyh.springfarmework.beans.BeansException;

/**
 * @author sora
 * @description
 */
public interface BeanFactory {
    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... arg) throws BeansException;
}
