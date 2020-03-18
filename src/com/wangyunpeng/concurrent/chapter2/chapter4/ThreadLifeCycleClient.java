package com.wangyunpeng.concurrent.chapter2.chapter4;

import java.util.Arrays;

public class ThreadLifeCycleClient {
    public static void main(String[] args) {
        new ThreadLifeCycleObserver().concurrentyQuery(Arrays.asList("1", "2", "3"));
    }
}
