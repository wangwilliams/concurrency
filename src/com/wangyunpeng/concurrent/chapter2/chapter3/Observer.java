package com.wangyunpeng.concurrent.chapter2.chapter3;

public abstract class Observer {
    protected Subject subject;
    public Observer(Subject subject){
        this.subject = subject;
        subject.attach(this);
    }
    public abstract void update();
}
