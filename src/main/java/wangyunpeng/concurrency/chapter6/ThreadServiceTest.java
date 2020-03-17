package main.java.wangyunpeng.concurrency.chapter6;

import main.java.wangyunpeng.concurrency.chapter6.service.ThreadService;

public class ThreadServiceTest {
    public static void main(String[] args) {
        ThreadService service = new ThreadService();
        long start = System.currentTimeMillis();
        service.execute(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.shutDown(10_000);
        long end = System.currentTimeMillis();
        System.out.println(end -start);
    }
}
