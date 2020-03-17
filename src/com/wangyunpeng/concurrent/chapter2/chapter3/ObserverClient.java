package com.wangyunpeng.concurrent.chapter2.chapter3;

public class ObserverClient {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);
        System.out.println("==========================");
        subject.setState(19);
        subject.setState(10);
    }
}
