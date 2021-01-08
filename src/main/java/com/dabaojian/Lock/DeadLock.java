package com.dabaojian.Lock;

/**
 * 死锁：多个线程互相抱着对方的需要的资源，然后形成僵持的局面
 */
public class DeadLock {
    public static void main(String[] args) {
        Huazhuang h1 = new Huazhuang(0,"灰姑娘");
        Huazhuang h2 = new Huazhuang(1,"白雪公主");
        h1.start();
        h2.start();
    }
}

// 口红
class Kouhong{
}

// 镜子
class Jingzi{
}

class Huazhuang extends Thread{
    static Kouhong kouhong = new Kouhong();
    static Jingzi jingzi = new Jingzi();

    int choice;
    String person;

    Huazhuang(int choice, String person){
        this.choice = choice;
        this.person = person;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void makeup() throws Exception{
        if(choice == 0){
            synchronized (kouhong){
                Thread.sleep(1000);
                System.out.println(this.person+"获取到了口红的锁");

                synchronized (jingzi){
                    System.out.println(this.person+"获取到了镜子的锁");
                }
            }
        }else {
            synchronized (jingzi){
                Thread.sleep(1000);
                System.out.println(this.person+"获取到了镜子的锁");

                synchronized (kouhong){
                    System.out.println(this.person+"获取到了口红的锁");
                }
            }
        }
    }
}