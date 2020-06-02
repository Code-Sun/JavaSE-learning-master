package com.edu.sunyifeng.callBack.demo2;

public class XiaoMing implements EatRice {

    /**
     * 小明和小李一起吃饭
     */
    public void eatFood() {
        XiaoLi xl = new XiaoLi();
        //小明调用小李的方法
        //this指的是小明这个类实现的EatRice接口
        // 一下两种写法都行
        xl.washFace("大龙虾", this);
        // xl.washFace("大龙虾",this::eat);

    }

    @Override
    public void eat(String food) {
        System.out.println("小明和小李一起去吃" + food);
    }
}
