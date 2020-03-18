package com.wangyunpeng.concurrent.chapter2.chapter6;

/**
 * 1.read read  可以并行
 * 2.read write 不允许并行
 * 3.write write 不允许并行
 */

public class ReadWriteLock {
    //有几个线程对它进行读的操作
    private int readingReaders = 0;
    // 有几个线程想读但是读不了
    private int waitingReaders = 0;
    // 当前有多少个线程等着写它（最多为0个）
    private int writingWriters = 0;
    // 当前有几个线程等着对它进行写操作
    private int waitingWriters = 0;

    private boolean preferWriter = true;

    public ReadWriteLock() {
        this(true);
    }

    public ReadWriteLock(boolean preferWriter) {
        this.preferWriter = preferWriter;
    }

    /**
     * 如果线程没有在被写，那么我们获得写的锁
     *
     * @throws InterruptedException
     */
    public synchronized void readLock() throws InterruptedException {
        this.waitingReaders++;
        try {
            while (writingWriters > 0 || (preferWriter && waitingWriters > 0)) {
                this.wait();
            }
            this.readingReaders++;
        } finally {
            this.waitingReaders--;
        }
    }

    public synchronized void readUnLock() {
        this.readingReaders--;
        this.notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        this.waitingWriters++;
        try {
            while (readingReaders > 0 || writingWriters > 0) {
                this.wait();
            }
            this.writingWriters++;
        } finally {
            this.waitingWriters--;
        }
    }

    public synchronized void writeUnlock() {
        this.writingWriters--;
        notifyAll();
    }
}
