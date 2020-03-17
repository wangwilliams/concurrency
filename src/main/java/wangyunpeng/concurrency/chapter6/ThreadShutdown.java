package main.java.wangyunpeng.concurrency.chapter6;



public class ThreadShutdown {

     static class Worker extends Thread{
        private boolean start = true;
        @Override
        public void run() {
           // connection
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        worker.start();
        Thread.sleep(3_000);
        worker.interrupt();
    }
}
