package com.edu.sunyifeng.extend;

public abstract class Animal {

    protected int legs;

    protected void Animal(int legs) {
        this.legs = legs;
    }

    public abstract void eat();

    public void walk() {
        System.out.println("动物用" + this.legs + "条腿走路");
    }
}
