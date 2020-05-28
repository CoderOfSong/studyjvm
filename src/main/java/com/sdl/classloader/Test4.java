package com.sdl.classloader;

/**
 * @program studyjvm
 * @description: 初始化只进行一次，而且是在第一次 主动使用 时加载
 * @author: songdeling
 * @create: 2020/05/18 11:55
 */
public class Test4 {
    public static void main(String[] args) {
        //Parent4 parent4 = new Parent4();//会打印static块中的语句
        //System.out.println("====");
        //Parent4 parent5 = new Parent4();//不会打印static块中的语句
        System.out.println("*******");

        /*
        引用类型的数组实例
        运行期生成的对象，类似于动态代理，并不会导致Parent4的初始化
        其父类型就是Object
        对于数组来说，JavaDoc经常将构成数组的元素称为Component，实际上就是将数组降低一个维度后的类型
         */
        Parent4[] parent4s = new Parent4[1];
        System.out.println(parent4s.getClass());//class [Lcom.sdl.classloader.Parent4
        System.out.println("*******");

        /*
        原生类型的数组实例
         */
    }
}

class Parent4{
    static {
        System.out.println("Parent4 static block");
    }
}