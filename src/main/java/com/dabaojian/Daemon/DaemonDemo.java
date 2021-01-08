package com.dabaojian.Daemon;

/***
 * @desc:守护线程
 */
public class DaemonDemo {

    public static void main(String[] args) {
        Daemon daemon = new Daemon();
        Yonghu yonghu = new Yonghu();

        Thread thread = new Thread(daemon);
        thread.setDaemon(true);
        thread.start();

        new Thread(yonghu).start();
    }

}

// 守护线程
class Daemon implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("守护线程！");
        }
    }
}

// 用户线程
class Yonghu implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("每一天我们都要开心哟");
        }
        System.out.println("goodby world!");
    }
}