package com.dabaojian.Lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

    public static void main(String[] args) {
        SellTicket s1 = new SellTicket();

        new Thread(s1,"线程1").start();
        new Thread(s1,"线程2").start();
        new Thread(s1,"线程3").start();
    }

}

class SellTicket implements Runnable{

    private int tickets = 10;

    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try {
                lock.lock(); //枷锁
                if(tickets>0){
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+"获得了第"+tickets--+"张");
                }else{
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock(); //释放锁
            }
        }
    }
}
