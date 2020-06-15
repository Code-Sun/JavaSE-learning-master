package com.edu.sunyifeng.staticProxy;

/**
 * 饲养员 实现Cat接口，作为静态代理类实现。代理狮子的行为,代理类中可以新增一些其他行为
 * 代理类存在的意义是为了增加一些公共的逻辑代码
 */
public class FeederProxy implements Cat {

    private Cat cat;

    public FeederProxy() {
    }

    public FeederProxy(Cat cat) {
        if (cat instanceof Cat) {
            this.cat = cat;
        }
    }

    public void setCat(Cat cat) {
        if (cat instanceof Cat) {
            this.cat = cat;
        }
    }

    @Override
    public String eatFood(String foodName) {
        System.out.println("proxy Lion exec eatFood ");
        return cat.eatFood(foodName);
    }

    @Override
    public boolean running() {
        System.out.println("proxy Lion exec running.");
        return cat.running();

    }
}
