package com.yyh.springfarmework.beans.factory.config;

/**
 *  @author sora
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
