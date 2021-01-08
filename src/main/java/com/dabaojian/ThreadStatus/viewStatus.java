package com.dabaojian.ThreadStatus;

public class viewStatus {

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 1; i++) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // 观察状态
        Thread.State state = thread.getState();
        System.out.println(state);

        // 启动后
        thread.start();
        state = thread.getState();
        System.out.println(state);

        while (state != Thread.State.TERMINATED){
            state = thread.getState();
            System.out.println(state);
        }
    }
}
