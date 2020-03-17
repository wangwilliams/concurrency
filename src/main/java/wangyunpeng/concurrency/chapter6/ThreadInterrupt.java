package main.java.wangyunpeng.concurrency.chapter6;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(10_000);
                    } catch (InterruptedException e) {
                        System.out.println("收到打断信号.");
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
        Thread.sleep(1_000);
        System.out.println("T is interrupted: "+t.isInterrupted());
        t.interrupt();
        System.out.println("T is interrupted: "+t.isInterrupted());


    }
}
