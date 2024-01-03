package com.yyh.springfarmework.beans.factory.config;

/**
 * Bean的属性引用
 * @author sora
 */
public class BeanReference {
    private String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
