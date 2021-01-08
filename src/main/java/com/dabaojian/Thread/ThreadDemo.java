package com.dabaojian.Thread;

/**
 * @desc：描述
 * 过程：1.集成Thread类  2.重写run方法 3.创建Thread对象 4.调用start方法启动多线程
 * 总结：线程开启不一定立即执行，而是由cpu调度安排，谁先拿到谁执行
 */
public class ThreadDemo extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("我是Thread---"+i+"线程！");
        }
    }

    public static void main(String[] args) {
        ThreadDemo thread = new ThreadDemo();
        thread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("我是---"+i+"线程！");
        }
    }
}
