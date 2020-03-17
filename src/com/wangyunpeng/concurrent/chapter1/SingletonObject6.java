package com.wangyunpeng.concurrent.chapter1;

public class SingletonObject6 {

    private SingletonObject6(){

    }
    // static 在线程运行的时候只会被加载一次，而且严格的线程同步
    // 这个内部静态类会在程序第一次的调用这个类的时候主动加载解决了效率问题
    private static class InstanceHolder{
        private final static SingletonObject6 instance = new SingletonObject6();
    }

    public static SingletonObject6 getInstance(){
        return InstanceHolder.instance;
    }
}
