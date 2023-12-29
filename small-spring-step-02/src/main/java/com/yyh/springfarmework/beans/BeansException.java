package com.yyh.springfarmework.beans;

/**
 * @author sora
 * @description
 */

public class BeansException extends RuntimeException {
    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Exception e) {
        super(message, e);
    }
}
