package com.lancq.java7;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Fork Join 实例
 *
 * @Author lancq
 * @Description
 * @Date 2018/11/4
 **/
public class ForkJoinDemo {
    public static void main(String[] args) {

        System.out.printf("当前CPU处理器数：%d\n", Runtime.getRuntime().availableProcessors());

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        forkJoinPool.invoke(new RecursiveAction() {
            @Override
            protected void compute() {
                System.out.printf("[Thread : %s]Hello World\n", Thread.currentThread().getName());
            }
        });
    }
}
