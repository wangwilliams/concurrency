package main.java.wangyunpeng.concurrency.chapter9;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CaptureService {
    private final static LinkedList<Control> controls = new LinkedList<>();
    private final static int MAX_THREAD_SIZE = 5;

    public static void main(String[] args) {
        List<Thread> worker = new LinkedList<>();

        Arrays.asList("M1", "M2", "M3", "M4", "M5", "M6", "M7", "M8", "M9","M10").stream()
                .map(CaptureService::createCaptureThread)
                .forEach(t->{
                    t.start();
                    worker.add(t);
                });
        worker.stream().forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Optional.of("All of capture worked finished").ifPresent(System.out::println);
    }

    private static Thread createCaptureThread(String name){
        return new Thread(()->{
            Optional.of("The worker ["+Thread.currentThread().getName()+"] begin capture.").ifPresent(System.out::println);
            synchronized (controls){
                while (controls.size() >= MAX_THREAD_SIZE){
                    try {
                        controls.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                controls.addLast(new Control());
            }
            Optional.of("The worker ["+Thread.currentThread().getName()+"] is capturing.").ifPresent(System.out::println);
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (controls){
                controls.removeFirst();
                Optional.of("The worker ["+Thread.currentThread().getName()+"] END.").ifPresent(System.out::println);
                controls.notifyAll();
            }
        },name);
    }

    private static class Control{

    }
}
