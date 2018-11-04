package com.lancq.java8;

import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author lancq
 * @Description
 * @Date 2018/11/4
 **/
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//         //1.完成操作
//        CompletableFuture<String> completableFuture = new CompletableFuture();
//
//        completableFuture.complete("Hello World");
//
//        String value = completableFuture.get();
//
//        System.out.println(value);


//        //2.异步执行,阻塞操作
//        CompletableFuture supplyAsyncCompletableFuture = CompletableFuture.runAsync(()->{
//            System.out.println("Hello World");
//        });
//        //仍然是阻塞操作
//        supplyAsyncCompletableFuture.get();
//        System.out.println("Start...");


        CompletableFuture supplyAsyncCompletableFuture = CompletableFuture.supplyAsync(()->{
            //获取数据操作，假设来源于数据库
            return String.format("[Thread : %s]Hello World", Thread.currentThread().getName());
        }).thenApply(value ->{
            return value + " - 来自于数据库";
        }).thenApply(value ->{
            return value + " at " + LocalDate.now();
        }).thenAccept(value ->{
            System.out.println(value);
        }).thenRun(()->{
            System.out.println("操作结束");
        });

        while (!supplyAsyncCompletableFuture.isDone()){

        }
        System.out.println("Start...");
    }
}
