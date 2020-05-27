package com.edu.sunyifeng.extend;

public class Cat extends Animal implements Pet {
    String name;

    protected void Cat(String name, int legs) {

        //有错误，暂时注释
        // super(4);
        this.name = name;
    }

    public void Cat() {
        // this(" ", 4);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void play() {
        System.out.println("猫喜欢玩水！");
    }

    public void eat() {
        System.out.println("猫吃的食物是鱼~");
    }
}
