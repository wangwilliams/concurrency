package main.java.wangyunpeng.concurrency.chapter8;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.stream.Stream;

public class ProductConsumeConduct {
    private Object Lock = new Object();
    public static int i = 0;
    public boolean isProducted = false;
    public void product(){
        synchronized (Lock){
            // while 循环很关键，如果抢到锁了，现在while里面判定一下，然后再放出来，否在卡在wait状态的线程会直接往下走
            while (isProducted) {
                try {
                    Lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i++;
            System.out.println("P->"+i);
            isProducted = true;
            Lock.notifyAll();
        }
    }

    public void Consume(){
        synchronized (Lock){
            while (!isProducted){
                try {
                    Lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("C->"+i);
            isProducted = false;
            Lock.notifyAll();
        }
    }

    public static void main(String[] args) {
        ProductConsumeConduct productConsumeConduct = new ProductConsumeConduct();
        Stream.of("P1","P2","P3").forEach(n->
            new Thread(){
                @Override
                public void run() {
                    while (true)
                        productConsumeConduct.product();
                }
            }.start()
        );
        Stream.of("C1","C2","C3","C4").forEach(n->
            new Thread(){
                @Override
                public void run() {
                    while (true)
                        productConsumeConduct.Consume();
                }
            }.start()
        );
    }
}
