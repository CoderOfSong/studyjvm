package com.sdl.classloader;

/**
 * @program studyjvm
 * @description: 对于静态字段来说，只有定义了该字段的类才会被初始化
 * 如下例，
 * 1.我们通过子类访问父类的静态字段str，这时我们是主动使用了父类Parent，
 * 虽然我们用子类去调用父类字段，但是我们并没有主动使用子类child，所以child不会被初始化，
 * 所以child的静态代码块不会被执行
 * 2.当我们调动child中的静态字段str2时，这时我们是主动使用了子类Child，
 * 但是根据主动使用的定义（详见"类加载过程中的备注"）-- 初始化一个类的子类，该类也会被主动使用，
 * 这时父类Parent也会被初始化（这里引出一个，第一个被初始化的类是Object，因为所有类都继承于Object
 * 可以添加JVM参数-XX:+TraceClassLoading追踪类的加载过程）
 * @author: songdeling
 * @create: 2020/05/14 09:36
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println(Child.str);
        System.out.println("=============");
        //System.out.println(Child.str2);
    }
}

class Parent{
    public static String str = "hello world";

    static {
        System.out.println("Parent static block");
    }
}

class Child extends Parent{
    //public static String str2 = "hello child";
    static {
        System.out.println("Child static block");
    }
}


