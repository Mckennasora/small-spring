package com.yyh.springfarmework.beans.factory.config;


import com.yyh.springfarmework.beans.PropertyValues;

/**
 * bean的描述类
 * 把上一章节中的 Object bean 替换为 Class，
 * 这样就可以把 Bean 的实例化操作放到容器中处理了。
 * @author sora
 */
public class BeanDefinition {

    private Class beanClass;
    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }
    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }
}
