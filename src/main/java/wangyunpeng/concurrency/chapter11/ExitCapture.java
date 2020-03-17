package main.java.wangyunpeng.concurrency.chapter11;

public class ExitCapture {
    private static int i = 0;
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("The application will be exit.");
        }));
        while (true){
            try {
                Thread.sleep(1_000L);
                System.out.println("I am working...");
            } catch (InterruptedException e) {
            }
            i++;
            if (i >20) throw new RuntimeException("error");
        }
    }
}
