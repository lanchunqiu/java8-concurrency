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
//         //1.��ɲ���
//        CompletableFuture<String> completableFuture = new CompletableFuture();
//
//        completableFuture.complete("Hello World");
//
//        String value = completableFuture.get();
//
//        System.out.println(value);


//        //2.�첽ִ��,��������
//        CompletableFuture supplyAsyncCompletableFuture = CompletableFuture.runAsync(()->{
//            System.out.println("Hello World");
//        });
//        //��Ȼ����������
//        supplyAsyncCompletableFuture.get();
//        System.out.println("Start...");


        CompletableFuture supplyAsyncCompletableFuture = CompletableFuture.supplyAsync(()->{
            //��ȡ���ݲ�����������Դ�����ݿ�
            return String.format("[Thread : %s]Hello World", Thread.currentThread().getName());
        }).thenApply(value ->{
            return value + " - ���������ݿ�";
        }).thenApply(value ->{
            return value + " at " + LocalDate.now();
        }).thenAccept(value ->{
            System.out.println(value);
        }).thenRun(()->{
            System.out.println("��������");
        });

        while (!supplyAsyncCompletableFuture.isDone()){

        }
        System.out.println("Start...");
    }
}