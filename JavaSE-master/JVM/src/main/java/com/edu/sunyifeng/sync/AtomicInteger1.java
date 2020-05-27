package com.edu.sunyifeng.sync;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: sunyifeng
 * @Date: 2020/04/22/17:25
 * @Description: AtomicInteger原子性操作
 *
 */
public class AtomicInteger1 {

    private static AtomicInteger m = new AtomicInteger(0);

    public static void main(String[] args) throws Exception{

        Thread[] threads = new Thread[100];
        final CountDownLatch latch = new CountDownLatch(threads.length);
        for (int i = 0; i < threads.length ; i++) {
            threads[i]=new Thread(()->{
                for (int j = 0; j < 10000 ; j++) {
                    m.incrementAndGet();
                }
                latch.countDown();
            });
        }

        Arrays.stream(threads).forEach((t)->t.start());
        // 让所有现成启动等待
        latch.await();
        System.out.println(m);
    }

}
