package com.edu.sunyifeng.JOL;

import org.openjdk.jol.info.ClassLayout;

/**
 * 假如处于偏向状态，这是来了竞争者，那么他的状态是什么？
 * 观察markword的值
 */
public class JOL3 {

    public static void main(String[] args) throws Exception{

        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        synchronized(o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }

    }
}
