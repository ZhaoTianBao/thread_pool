package com.tuling.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {
       Long start =  System.currentTimeMillis();
       final Random random = new Random();
       final List<Integer> list = new ArrayList<>();
       //创建1个子线程  +  1个main主线程  方法级别调用  线程池调用 用到start 一定是多线程，run不是多线程
       ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 100000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            });

        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("时间: " + (System.currentTimeMillis() - start));
        System.out.println("大小: " + list.size());
    }



}
