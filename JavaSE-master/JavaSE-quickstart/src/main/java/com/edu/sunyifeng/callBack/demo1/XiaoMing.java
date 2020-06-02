package com.edu.sunyifeng.callBack.demo1;

public class XiaoMing {

    /**
     * 小明和小李一起吃饭
     */
    public void eatFood() {
        XiaoLi xl = new XiaoLi();
        xl.washFace();
    }

    public void eat() {
        System.out.print("小明和小李一起去吃大龙虾");
    }

}
