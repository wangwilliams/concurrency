package com.wangyunpeng.concurrent.chapter1;

public class SingletonObject1 {
    private static final SingletonObject1 instance = new SingletonObject1();

    private SingletonObject1(){
        //
    }

    public SingletonObject1 getInstance() {
         return instance;
    }
}


class SingletonLazyObject{
    private static volatile SingletonLazyObject instance = null;

    private SingletonLazyObject() {
    }

    public SingletonLazyObject getInstance(){
        if (instance == null) {                                     // 1 走到这里
            instance = new SingletonLazyObject();                   // 2 走到这里 会导致生成两个对象
        }
        return SingletonLazyObject.instance;
    }
}

class SingletonDoubleCheckObject{
    private static SingletonDoubleCheckObject instance = null;

    private SingletonDoubleCheckObject() {
    }

    public SingletonDoubleCheckObject getInstance(){
        if (instance == null) {                                     //
            synchronized (SingletonDoubleCheckObject.class){
                if (instance == null) {
                    instance = new SingletonDoubleCheckObject();
                }
            }
        }
        return SingletonDoubleCheckObject.instance;
    }
}