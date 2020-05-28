package com.sdl.classloader;

/**
 * @program studyjvm
 * @description:
 * @author: songdeling
 * @create: 2020/05/28 14:26
 */
public class Test6 {
    public static void main(String[] args) throws Exception {
        /**
         * 类加载
         */
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> aClass = systemClassLoader.loadClass("com.sdl.classloader.Sample");
        System.out.println(aClass);
        System.out.println("=========");

        /**
         * 反射，主动使用的七种之一
         */
        Class<?> aClass1 = Class.forName("com.sdl.classloader.Sample");
        System.out.println(aClass1);
    }
}


class Sample {
    static {
        System.out.println("Class Sample");
    }
}
