package main.java.wangyunpeng.concurrency;

/**
 * @author wangyunpeng
 * @Date 2020/3/7
 */
public class TryConcurrency {
    public static void main(String[] args){
        for (int i = 0; i < 100; i++) {
            readFromDatabase();
            writeDataToFile();
        }
    }

    private static void readFromDatabase(){
        // read data from database and handle it
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    println("Begin read data from db.");
                    Thread.sleep(10000*10L);
                    println("Read data done and start handle it.");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                println("The data handle finish and successfully.");
            }
        });
        thread.start();
    }

    private static void writeDataToFile(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    println("Begin write data from db.");
                    Thread.sleep(10000*10L);
                    println("write data done and start handle it.");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                println("The data handle finish and successfully.");
            }
        });
      t.start();
    }

    private static void println(String message){
        System.out.println(message);
    }
}
