package com.wangyunpeng.concurrent.chapter2.chapter3;

public class OctalObserver extends Observer {
    public OctalObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Octal Number: "+Integer.toOctalString(subject.getState()));
    }
}
