package com.edu.sunyifeng.staticProxy;

/**
 * 定义了一个猫科动物的两个行为接口，吃东西，奔跑
 * 作为代理类 和委托类之间的约束接口
 */
public interface Cat {
    /**
     *
     * @param foodName
     * @return
     */
    String eatFood(String foodName);
    boolean running();
}
