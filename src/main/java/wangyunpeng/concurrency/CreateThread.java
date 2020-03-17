package main.java.wangyunpeng.concurrency;

public class CreateThread {
    public static void main(String[] args) {
        Thread t = new Thread();
        t.start();
        System.out.println(t.getName());
    }
}
