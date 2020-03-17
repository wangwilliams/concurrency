package main.java.wangyunpeng.concurrency.chapter12;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SimpleThreadPool {
    private final int size;
    private final static int DEFAULT_SIZE = 10;
    private final static int DEFAULT_TASK_QUEUE_SIZE = 2000;
    private static volatile int seq = 0;
    private final static String THREAD_PREFIX = "SIMPLE_THREAD_POOL-";
    private final static LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();
    private final static List<WorkerTask> THREAD_QUEUE = new ArrayList<>();
    private final int queueSize;

    public SimpleThreadPool() {
        this(DEFAULT_SIZE, DEFAULT_TASK_QUEUE_SIZE);
    }

    public SimpleThreadPool(int size, int queueSize) {
        this.size = size;
        this.queueSize = queueSize;
    }

    private void init() {
        for (int i = 0; i < size; i++) {
            createWorkTask();
        }
    }

    private void createWorkTask() {

    }

    private class WorkerTask {

    }
}
