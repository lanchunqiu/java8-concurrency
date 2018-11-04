package com.lancq.java5;

import java.util.concurrent.*;

/**
 * Callable���з���ֵ��
 *
 * @Author lancq
 * @Description
 * @Date 2018/11/4
 **/
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //ִ�������̳߳أ�ThreadPoolExecutor��ֻ����һ��ʵ��
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(new Callable<String>() {
            @Override
            public String call() {
                System.out.printf("[Thread : %s]Hello World\n", Thread.currentThread().getName());
                return "Hello World";
            }
        });


        executorService.shutdown();

    }
}
