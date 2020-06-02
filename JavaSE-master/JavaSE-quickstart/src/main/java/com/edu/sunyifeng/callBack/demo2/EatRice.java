package com.edu.sunyifeng.callBack.demo2;

/*
资料来源
https://blog.csdn.net/fengye454545/article/details/80198446

新建一个吃饭的接口EatRice，接口中有个抽象方法eat()。在小明中调用这个接口，并实现eat()；小李声明这个接口对象，
并且调用这个接口的抽象方法
 */
public interface EatRice {
    void eat(String food);
}
