package main.java.wangyunpeng.concurrency.Thread;

import main.java.wangyunpeng.concurrency.chapter6.service.ThreadService;

public class TicketWindowRunnable implements Runnable {
    private int index = 0;
    public static final int MAX = 50;
    private final Object MONITOR = new Object();
    @Override
    public void run() {
        while (true){
           synchronized (MONITOR){
               if (index > MAX){
                   break;
               }
               try {
                   Thread.sleep(50);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(Thread.currentThread()+" 的号码是： "+index++);
           }
        }
    }
}
