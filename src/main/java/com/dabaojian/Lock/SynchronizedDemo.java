package com.dabaojian.Lock;

public class SynchronizedDemo{

    public static void main(String[] args) {
        ButTicket T1 = new ButTicket();

        new Thread(T1,"T1").start();
        new Thread(T1,"T2").start();
        new Thread(T1,"T3").start();
    }

}

class ButTicket implements Runnable{

    private int ticketNum = 20;
    boolean flag = true;

    @Override
    public void run() {
        while (flag){
            buy();
        }
    }

    // synchronized默认的是this，也就是对象的本身
    private synchronized void buy(){
        if(ticketNum<=0){
            flag = false;
            return;
        }
        try {
            Thread.sleep(1000); //休眠放大线程安全问题
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"买到第"+ticketNum--+"张票");
    }

}
