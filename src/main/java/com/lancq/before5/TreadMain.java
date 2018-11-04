package com.lancq.before5;

/**
 * Java Thread/Runnable ���ģʽ��Java 5 ֮ǰ��
 *
 * @Author lancq
 * @Description
 * @Date 2018/11/4
 **/
public class TreadMain {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            public synchronized void run() {
                System.out.printf("[Thread : %s]Hello World\n", Thread.currentThread().getName());
            }
        }, "Sub");

        thread.start();

        System.out.printf("[Thread : %s]Starting...\n", Thread.currentThread().getName());
    }
}
