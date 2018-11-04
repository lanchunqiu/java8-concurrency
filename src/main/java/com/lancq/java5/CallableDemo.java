package com.lancq.java5;

import java.util.concurrent.*;

/**
 * Callable是有返回值的
 *
 * @Author lancq
 * @Description
 * @Date 2018/11/4
 **/
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //执行器，线程池（ThreadPoolExecutor）只是其一种实现
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
