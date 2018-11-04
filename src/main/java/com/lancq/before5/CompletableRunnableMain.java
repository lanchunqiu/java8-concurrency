package com.lancq.before5;

/**
 * @Author lancq
 * @Description
 * @Date 2018/11/4
 **/
public class CompletableRunnableMain {

    public static void main(String[] args) throws InterruptedException {
        CompleteRunnable runnable = new CompleteRunnable();

        Thread thread = new Thread(runnable, "Sub");

        thread.start();

        thread.join();

        System.out.printf("[Thread : %s]Starting...\n", Thread.currentThread().getName());
        System.out.printf("runnable is completed: %s \n", runnable.isComplete());
    }


    private static class CompleteRunnable implements Runnable{
        private volatile boolean complete = false;

        @Override
        public void run() {
            System.out.printf("[Thread : %s]Hello World\n", Thread.currentThread().getName());
            complete = true;
        }

        public boolean isComplete() {
            return complete;
        }

    }
}
