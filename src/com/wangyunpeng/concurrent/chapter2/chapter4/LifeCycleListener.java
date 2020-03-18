package com.wangyunpeng.concurrent.chapter2.chapter4;

public interface LifeCycleListener {

    void onEvent(ObserverRunnable.RunnableEvent event);
}
