package main.java.wangyunpeng.concurrency;

import main.java.wangyunpeng.concurrency.Thread.TicketWindowRunnable;
import main.java.wangyunpeng.concurrency.chapter7.SychronizedRunnable;

public class Bank {
    public static void main(String[] args) {
        final SychronizedRunnable ticketWindow = new SychronizedRunnable();
        Thread windowThread1 = new Thread(ticketWindow,"一号窗口");
        Thread windowThread2 = new Thread(ticketWindow,"二号窗口");
        Thread windowThread3 = new Thread(ticketWindow,"三号窗口");
        windowThread1.start();
        windowThread2.start();
        windowThread3.start();
    }
}
