package com.example.demo.Thread;

import java.util.concurrent.*;

/**
 * @desc：描述
 * 过程：1.实现Callable接口  2.重写call方法 3.创建目标对象 4.创建执行服务 5.提交执行 6.获取执行结果 7.关闭服务
 * 总结：线程开启不一定立即执行，而是由cpu调度安排，谁先拿到谁执行
 */
public class CallableDemo implements java.util.concurrent.Callable {

    @Override
    public Boolean call() throws Exception {
        return true;
    }

    public static void main(String[] args) throws Exception {
        // 创建对象
        CallableDemo callable = new CallableDemo();
        // 创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(1);
        // 提交执行
        Future<Boolean> f1 = ser.submit(callable);
        // 获取返回结果
        boolean result = f1.get();
        // 关闭执行服务
        ser.shutdown();
    }
}
