package main.java.wangyunpeng.concurrency.chapter7;

public class SychronizedRunnable implements Runnable {

    private int index = 0;
    public static final int MAX = 50;
    private final Object MONITOR = new Object();
    @Override
    public void run() {
        while (true){
            if (!ticket()){
                break;
            }
        }
    }

    private synchronized boolean ticket(){
        if (index > MAX){
            return false;
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread()+" 的号码是： "+index++);
        return true;
    }
}
