package com.edu.sunyifeng.callBack.demo3;

public class XiaoMing implements EatRice{

    //小明和小李一起吃饭
    public void eatFood() {
        XiaoLi xl = new XiaoLi();
        xl.setEatRiceListener(this,"大龙虾");
    }

    @Override
    public void eat(String food) {
        System.out.println("小明和小李一起去吃" + food);
    }
}
