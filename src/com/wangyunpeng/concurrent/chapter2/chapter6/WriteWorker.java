package com.wangyunpeng.concurrent.chapter2.chapter6;

import java.util.Random;

public class WriteWorker extends Thread {
    private static final Random random = new Random(System.currentTimeMillis());

    private final SharedData data;

    private final String filter;

    private int index = 0;

    public WriteWorker(SharedData data, String filter) {
        this.data = data;
        this.filter = filter;
    }

    @Override
    public void run() {
        while (true) {
            char c = nextChar();
            try {
                data.write(c);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private char nextChar() {
        char c = filter.charAt(index);
        index++;
        if (index >= filter.length()) {
            index = 0;
        }
        return c;
    }
}
