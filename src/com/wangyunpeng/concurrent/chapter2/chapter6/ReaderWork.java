package com.wangyunpeng.concurrent.chapter2.chapter6;

public class ReaderWork extends Thread {
    private final SharedData data;

    public ReaderWork(SharedData data) {
        this.data = data;

    }

    @Override
    public void run() {
        try {
            while (true) {

                char[] readBuffer = data.read();
                System.out.println(Thread.currentThread().getName() + " reads " + String.valueOf(readBuffer));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
