package com.yyh.springframework.test.bean;

public class UserService {
    private String name;
    private int age;

    public UserService(String name) {
        this.name = name;
    }

    public UserService(int age) {
        this.age = age;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("名字:").append(name).append(",");
        sb.append("年龄:").append(age);
        return sb.toString();
    }
}
