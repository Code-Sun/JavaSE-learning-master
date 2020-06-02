package com.edu.sunyifeng.callBack.demo3;

public class Test {
    /**
     * 上面讲的都是同步回调，可是事实上，小李要洗漱后才能吃饭，在小李洗漱的时候，小明是要做自己的事情的，比如他在玩手机，
     * 这样子就是异步回调了
     * @param args
     */
    public static void main(String[] args) {
        XiaoMing xm = new XiaoMing();
        xm.eatFood();
    }
}
