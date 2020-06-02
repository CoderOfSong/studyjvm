package com.sdl.jvmtools;

import java.util.ArrayList;
import java.util.List;

/**
 * @program studyjvm
 * @description: 堆内存溢出
 * 指定一下堆内存大小  -Xms128m -Xmx256m
 *
 * #出现 OOME 时生成堆 dump:
 * -XX:+HeapDumpOnOutOfMemoryError
 * #生成堆文件地址：
 * -XX:HeapDumpPath=/Users/songdeling/JavaProgram/studyjvm/jvmlogs/
 * @author: songdeling
 * @create: 2020/05/29 08:45
 */
public class Test2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        for (; ; ){
            list.add(new String("123"));
        }
    }
}
