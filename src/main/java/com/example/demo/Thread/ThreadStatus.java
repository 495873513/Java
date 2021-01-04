package com.example.demo.Thread;

public class ThreadStatus implements Runnable{

    /**
     * @desc：线程停止
     * 1.官方不建议用stop方法，使用标志位
     * */
    /*private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while(flag){
            System.out.println("我是Thread---线程"+i++);
        }
    }

    public void stop(){
        this.flag = false;
    }

    public static void main(String[] args) {
        ThreadStatus threadStatus = new ThreadStatus();
        new Thread(threadStatus).start();

        for (int i = 0; i < 100; i++) {
            if(i == 50){
                threadStatus.stop();
            }
            System.out.println("我是---"+i+"线程！");
        }
    }*/





}
