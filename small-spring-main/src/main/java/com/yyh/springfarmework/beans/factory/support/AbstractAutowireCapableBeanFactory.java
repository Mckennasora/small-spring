package com.yyh.springfarmework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.yyh.springfarmework.beans.BeansException;
import com.yyh.springfarmework.beans.PropertyValue;
import com.yyh.springfarmework.beans.PropertyValues;
import com.yyh.springfarmework.beans.factory.config.BeanDefinition;
import com.yyh.springfarmework.beans.factory.config.BeanReference;


import java.lang.reflect.Constructor;

/**
 * 实现了 Bean 的实例化操作newInstance
 *
 * @author sora
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    // bean的生成策略，默认CGLIB
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }

    @Override
    protected <T> T createBeanByType(String beanName, BeanDefinition beanDefinition, Class<T> requiredType) {
        T bean = null;
        try {
            bean = createBeanInstanceByType(beanDefinition, requiredType);
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }

    private <T> T createBeanInstanceByType(BeanDefinition beanDefinition, Class<T> requiredType) {
        try {
            return requiredType.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
    }

    //todo 这里只根据构造器的参数个数判断使用哪个构造器，不完整
    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse = null;
        Class beanClass = beanDefinition.getBeanClass();
        Constructor[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    /**
     * Bean 属性填充
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference) {
                    // A 依赖 B，获取 B 的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                // 属性填充
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }
}
