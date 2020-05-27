package com.edu.sunyifeng.extend;

public class Fish extends Animal implements Pet {
    private String name;

    protected void Fish(int legs) {

        //有错误，暂时注释
        // super(legs);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void play() {
        System.out.println("鱼很喜欢玩水");
    }

    @Override
    public void walk() {
        System.out.println("鱼不能走且没有腿");
    }

    public void eat() {
        System.out.println("鱼在吃东西");
    }
}
