package com.edu.sunyifeng.callBack.demo2;

/**
 * 这样子就通过接口的形式实现了软编码。通过接口的形式我可以实现小李洗漱完后，和小王一起去上网
 */
public class XiaoWang implements EatRice{

    /**
     小王和小李一起去上网
     */
    public void eatFood() {
        XiaoLi xl = new XiaoLi();
        //A调用B的方法
        xl.washFace("轻舞飞扬上网", this);
    }

    @Override
    public void eat(String bar) {
        System.out.println("小王和小李一起去" + bar);
    }
}
