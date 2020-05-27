package com.edu.sunyifeng.sync;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class CasAndUnsafe1 {

    private static int m=0;

    public static void main(String[] args) {

        Thread[] threads = new Thread[100];
        final CountDownLatch latch = new CountDownLatch(threads.length);
        for (int i = 0; i < threads.length ; i++) {
            threads[i]=new Thread(()->{
                for (int j = 0; j < 10000 ; j++) {
                    m++;
                }
                latch.countDown();
            });
        }

        Arrays.stream(threads).forEach((t)->t.start());
        System.out.println(m);
    }
}
