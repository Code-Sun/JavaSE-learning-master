package com.edu.sunyifeng.callBack.demo3;

public class XiaoLi {

    protected EatRice er;

    public void setEatRiceListener(EatRice er, String food) {
        this.er = er;
        washFace(food);
    }

    public void washFace(String food) {
        System.out.println("小李要洗漱");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    play();
                    Thread.sleep(3000);
                    System.out.print("3秒后 ");
                    //B调用A的方法
                    er.eat(food);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void play() {
        System.out.println("小明要玩手机");
    }
}
