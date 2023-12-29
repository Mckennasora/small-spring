package com.yyh.springfarmework.beans.factory.support;

import com.yyh.springfarmework.beans.BeansException;
import com.yyh.springfarmework.beans.factory.BeanFactory;
import com.yyh.springfarmework.beans.factory.config.BeanDefinition;

/**
 * 工厂模式（抽象方法模式）
 * 首先继承了 DefaultSingletonBeanRegistry，也就具备了使用单例注册类方法。
 * 关于接口 BeanFactory 的实现，在方法 getBean 的实现过程中可以看到，
 * 主要是对单例 Bean 对象的获取以及在获取不到时需要拿到 Bean的定义做相应 Bean 实例化操作。
 * 那么 getBean 并没有自身的去实现这些方法，
 * 而是只定义了调用过程以及提供了抽象方法，由实现此抽象类的其他类做相应实现。
 * @author sora
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) {

        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);

        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
