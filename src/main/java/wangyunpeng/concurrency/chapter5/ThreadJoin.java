package main.java.wangyunpeng.concurrency.chapter5;

import java.util.stream.IntStream;

public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            IntStream.range(1,1000).forEach(i->{
                System.out.println(Thread.currentThread().getName()+" "+i);
            });
        },"son Thread");
        Thread t2 = new Thread(()->{
            try {
                t1.join(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            IntStream.range(1,1000).forEach(i->{
                System.out.println(Thread.currentThread().getName()+" "+i);
            });
        },"son Thread2");
        t1.start();
        t2.start();
        t2.join();

        IntStream.range(1,1000).forEach(i->{
            System.out.println(Thread.currentThread().getName()+" "+i);
        });
        Thread.currentThread().join();
    }
}
