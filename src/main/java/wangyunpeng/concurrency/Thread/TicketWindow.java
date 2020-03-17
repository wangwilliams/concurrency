package main.java.wangyunpeng.concurrency.Thread;

public class TicketWindow extends Thread {
    private final int MAX = 50;

    private static int index = 1;

    private final String name;

    public TicketWindow(String name){
        this.name = name;
    }
    @Override
    public void run() {
        while (index <= MAX){
            System.out.println("柜台是： "+name+" 当前的号码是："+index++);
        }
    }
}
