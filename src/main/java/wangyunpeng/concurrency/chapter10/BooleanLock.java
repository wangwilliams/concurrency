package main.java.wangyunpeng.concurrency.chapter10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class BooleanLock implements Lock {
    // The initValue is true indicated the lock have be get.
    // the initValue is false inducated the lock is free(Other thread can get this)
    private boolean initValue;

    private Collection<Thread> blockThreadCollection = new ArrayList<>();

    private Thread currentThread;

    public BooleanLock(){
        this.initValue = false;
    }
    @Override
    public synchronized void lock() throws InterruptedException {
        while (initValue){
            blockThreadCollection.add(Thread.currentThread());
            this.wait();
        }
        Optional.of(Thread.currentThread().getName()+" have the lock Monitor")
                .ifPresent(System.out::println);
        this.currentThread = Thread.currentThread();
        blockThreadCollection.remove(Thread.currentThread());
        this.initValue = true;
    }

    @Override
    public synchronized void lock(long mills) throws InterruptedException, TimeOutException {
        if (mills <= 0){
            lock();
        }
        long hasRemaining = 0;
        long endTime = System.currentTimeMillis()+mills;
        while (initValue){
            if (hasRemaining > 0){
                throw new TimeOutException("Time out");
            }
            blockThreadCollection.add(Thread.currentThread());
            this.wait(mills);
            hasRemaining = System.currentTimeMillis()-endTime;
        }
        Optional.of(Thread.currentThread().getName()+" have the lock Monitor")
                .ifPresent(System.out::println);
        this.initValue = true;
        this.currentThread = Thread.currentThread();
        blockThreadCollection.remove(Thread.currentThread());
    }

    @Override
    public synchronized void unlock() {
        if(currentThread == Thread.currentThread()){
            this.initValue = false;
            Optional.of(Thread.currentThread() +" release the lock monitor.").ifPresent(System.out::println);
            this.notifyAll();
        }
    }

    @Override
    public Collection<Thread> getBlockThread() {
        // only get the thread collections ,unable change them.
        return Collections.unmodifiableCollection(blockThreadCollection);
    }

    @Override
    public int getBlockThreadSize() {
        return blockThreadCollection.size();
    }
}
