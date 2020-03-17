package main.java.wangyunpeng.concurrency.chapter11;

public class ThreadException {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            try {
                Thread.sleep(5_000);
                int result = 5/0;
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        // 通过这个方法可以将错误的线程，错误原因记录到
        t.setUncaughtExceptionHandler((thread,e)->{
            System.out.println(e);
            System.out.println(thread);
        });
        t.start();
    }
}
