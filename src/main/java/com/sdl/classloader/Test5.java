package com.sdl.classloader;

/**
 * @program studyjvm
 * @description: 当一个接口在初始化时，并不要求其父接口都完成了初始化
 * 只有在真正使用到父接口的时候(如引用接口中所定义的常量时)，才会初始化
 * @author: songdeling
 * @create: 2020/05/19 15:42
 */
public class Test5 {
    public static void main(String[] args) {
        System.out.println(Child5.b);
    }
}

interface Parent5{
    public static int a = 5;//接口中的成员变量默认都是 公开静态的
}

interface Child5 extends Parent5{
    public static int b = 6;
}
