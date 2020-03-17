package com.wangyunpeng.concurrent.chapter2;

import java.util.Optional;
import java.util.stream.IntStream;

public class VolatileTest {
    private volatile static int INIT_VALUE = 0;
    private final static int MAX_VALUE = 5;
    public static void main(String[] args) {
        new Thread(()->{
            int localValue = INIT_VALUE;
            while (localValue < MAX_VALUE) {
                if (localValue != INIT_VALUE) {
                    Optional.of("The value updated to ["+INIT_VALUE+"]\n").ifPresent(System.out::println);
                    localValue = INIT_VALUE;
                }
            }
        },"READER").start();

        new Thread(()->{
            int localValue = INIT_VALUE;
            while (INIT_VALUE < MAX_VALUE) {
                System.out.println("Update the value to [" + (++localValue)+"]\n");
                INIT_VALUE = localValue;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"UPDATER").start();
    }
}
