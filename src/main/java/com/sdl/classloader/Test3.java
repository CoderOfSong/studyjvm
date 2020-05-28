package com.sdl.classloader;

import java.util.UUID;

/**
 * @program studyjvm
 * @description: 当一个常量的值并非编译期间可以确定的，那么其值就不会被放到调用类的常量池中，
 * 这时在程序运行时，会导致主动使用这个常量所在的类，显然会导致这个类被初始化。
 * @author: songdeling
 * @create: 2020/05/18 09:34
 */
public class Test3 {
    public static void main(String[] args) {
        System.out.println(Parent3.str);
    }

}

class Parent3{
    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("Parent3 static block");
    }
}
