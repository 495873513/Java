package com.example.demo.Thread;

/**
 * @desc：描述
 * 过程：1.实现Runnable接口  2.重写run方法 3.创建对象 4.传入目标对象Thread.start()
 * 总结：线程开启不一定立即执行，而是由cpu调度安排，谁先拿到谁执行
 */
public class RunnableDemo implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("我是Runnable---"+i+"线程！");
        }
    }

    public static void main(String[] args) {
        RunnableDemo runnable = new RunnableDemo();

        new Thread(runnable).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("我是---"+i+"线程！");
        }
    }
}
