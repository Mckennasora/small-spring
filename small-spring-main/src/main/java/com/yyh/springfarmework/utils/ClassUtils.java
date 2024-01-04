package com.yyh.springfarmework.utils;

public class ClassUtils {

    // 获取默认的类加载器
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            // 获取当前线程的上下文类加载器
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {
            // 忽略异常
        }
        if (cl == null) {
            // 如果没有上下文类加载器，使用当前类的类加载器
            cl = ClassUtils.class.getClassLoader();
            if (cl == null) {
                // 如果当前类的类加载器也为空，使用系统类加载器
                try {
                    cl = ClassLoader.getSystemClassLoader();
                } catch (Throwable ex) {
                    // 忽略异常
                }
            }
        }
        return cl;
    }
}