package com.lancq.java5;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author lancq
 * @Description
 * @Date 2018/11/4
 **/
public class ExecutorDemo {
    public static void main(String[] args) {
        //ִ�������̳߳أ�ThreadPoolExecutor��ֻ����һ��ʵ��
        Executor executor = Executors.newFixedThreadPool(1);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.printf("[Thread : %s]Hello World\n", Thread.currentThread().getName());
            }
        });

        if(executor instanceof ExecutorService){
            ExecutorService executorService = ExecutorService.class.cast(executor);
            executorService.shutdown();
        }

    }
}
