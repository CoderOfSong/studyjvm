package com.sdl.jvmtools;

/**
 * @program studyjvm
 * @description: 死锁
 * @author: songdeling
 * @create: 2020/05/29 08:45
 */
public class Test1 {
    /**
     * 线程0 想要得到obj2 锁进行下面的操作，而obj2锁被线程1 所占有。
     * 线程1想得到obj1锁 进行下面的操作，而obj1锁被线程0 所占有。
     * @param args
     */
    public static void main(String[] args) {
        DieLock d1=new DieLock(true);
        DieLock d2=new DieLock(false);
        Thread t1=new Thread(d1);
        Thread t2=new Thread(d2);
        t1.start();
        t2.start();
    }
}

class MyLock{
    public static Object obj1=new Object();
    public static Object obj2=new Object();
}

class DieLock implements Runnable{
    private boolean flag;
    DieLock(boolean flag){
        this.flag=flag;
    }
    public void run() {
        if(flag) {
            while(true) {
                synchronized(MyLock.obj1) {
                    System.out.println(Thread.currentThread().getName()+"....if...obj1...");
                    synchronized(MyLock.obj2) {
                        System.out.println(Thread.currentThread().getName()+".....if.....obj2.....");

                    }
                }
            }
        }
        else {
            while (true) {
                synchronized (MyLock.obj2) {
                    System.out.println(Thread.currentThread().getName() + "....else...obj2...");
                    synchronized (MyLock.obj1) {
                        System.out.println(Thread.currentThread().getName() + ".....else.....obj1.....");

                    }
                }
            }
        }
    }
}