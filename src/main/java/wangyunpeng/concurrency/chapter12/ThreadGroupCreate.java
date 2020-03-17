package main.java.wangyunpeng.concurrency.chapter12;

public class ThreadGroupCreate {
    public static void main(String[] args) {
        ThreadGroup tg1 = new ThreadGroup("tg1");
        ThreadGroup tg2 = new ThreadGroup(tg1,"tg2");
        Thread t1 = new Thread(tg2,"t1"){
            @Override
            public void run() {
                try {
                    System.out.println(getThreadGroup().getName());
                    System.out.println(getThreadGroup().getParent());
                    System.out.println(getThreadGroup().getParent().getParent());
                    System.out.println(getThreadGroup().getParent().activeCount());
                    Thread.sleep(10_000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
    }
}
