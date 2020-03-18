package com.wangyunpeng.concurrent.chapter2.chapter6;

public class Client {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData(10);
        WriteWorker writeWorker = new WriteWorker(sharedData, "wangyunpeng");
        writeWorker.start();
        new ReaderWork(sharedData).start();
        new ReaderWork(sharedData).start();
        new ReaderWork(sharedData).start();
    }
}
