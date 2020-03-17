package main.java.wangyunpeng.concurrency.chapter5;

public class ThreadJoin3 {
    public static void main(String[] args) {
        long startTimeStamp = System.currentTimeMillis();
        Thread t1 = new Thread(new CaptureRunnable("M1",1_000));
        Thread t2 = new Thread(new CaptureRunnable("M2",5_000));
        Thread t3 = new Thread(new CaptureRunnable("M3",10_000));

        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        long endTimeStamp = System.currentTimeMillis();
        System.out.println("begin save data timestamp is : "+startTimeStamp+" end timestamp is:"+ endTimeStamp+" during :"+(endTimeStamp-startTimeStamp));
    }
}

class CaptureRunnable implements Runnable{
    private String machineName;

    private Long spendTime;

    public CaptureRunnable(String machineName,long spendTime){
        this.machineName = machineName;
        this.spendTime = spendTime;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(spendTime);
            System.out.println(machineName+" completed capture and successful");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getResult(){
        return machineName+" finish.";
    }
}
