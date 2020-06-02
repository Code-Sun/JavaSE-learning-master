package com.edu.sunyifeng.callBack.demo1;

public class XiaoLi {

    public void washFace() {
        System.out.println("小李要洗漱");
        XiaoMing xm = new XiaoMing();
        //回调,洗漱完后，一起去吃饭
        xm.eat();
    }

    /*
    小李的代码完全写死了，这样子的场合可能适用和小明一起去吃饭，可是假如小李洗漱完不吃饭了，想和小王上网去，
    这样子就不适用了
     */
}
