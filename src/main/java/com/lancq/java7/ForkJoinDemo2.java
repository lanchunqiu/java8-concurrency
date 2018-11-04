package com.lancq.java7;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.LongAdder;

/**
 * Fork Join 实例
 *
 * @Author lancq
 * @Description
 * @Date 2018/11/4
 **/
public class ForkJoinDemo2 {
    public static void main(String[] args) {

        System.out.printf("当前CPU处理器数：%d\n", Runtime.getRuntime().availableProcessors());

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //累加对象
        LongAdder longAdder = new LongAdder();

        //RecursiveAction 递归操作
        AddTask addTask = new AddTask(nums, longAdder);
        forkJoinPool.invoke(addTask);
        forkJoinPool.shutdown();

        System.out.println("累加结果"+longAdder);
    }

    private static class AddTask extends RecursiveAction{

        private final List<Integer> nums;
        private final LongAdder longAdder;

        public AddTask(List<Integer> nums, LongAdder longAdder) {
            this.nums = nums;
            this.longAdder = longAdder;
        }

        @Override
        protected void compute() {
            int size = nums.size();

            if(size > 1){
                int parts = size / 2;

                List<Integer> leftPart = nums.subList(0,parts);
                AddTask leftTask = new AddTask(leftPart,longAdder);

                List<Integer> rightPart = nums.subList(parts, size);
                AddTask rightTask = new AddTask(rightPart,longAdder);

                invokeAll(leftTask, rightTask);
            } else {
                if(size == 0){//保护
                    return;
                }
                Integer value = nums.get(0);

                //累加
                longAdder.add(value.intValue());
            }

        }
    }
}
