package main.java.wangyunpeng.concurrency;

public class ThreadStack {
    private static int counter = 0;
    private byte[] bytes = new byte[1024];

    // JVM will create thread named “main”
    public static void main(String[] args) {
        // create a JVM stack
        Thread t1 = new Thread(null,new Runnable() {
            @Override
            public void run() {
                try {
                    add(0);
                }catch (Error error) {
                    System.out.println(counter);
                }
            }

            private void add(int i) {
                ++counter;
                add(i + 1);
            }
        },"Test" ,1<<24);
        t1.start();
        t1.setPriority(Thread.MAX_PRIORITY);
    }
}
