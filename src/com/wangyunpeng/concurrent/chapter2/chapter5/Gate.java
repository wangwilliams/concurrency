package com.wangyunpeng.concurrent.chapter2.chapter5;

/**
 * shared Resource
 * 如果多个线程对于同一个资源共享
 */
public class Gate {
    private int counter = 0;
    private String name = "Nobody";
    private String address = "NoWhere";

    /**
     * 临界值
     *
     * @param name
     * @param address
     */
    public synchronized void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.address = address;
        verify();
    }

    private void verify() {
        if (this.name.charAt(0) != this.address.charAt(0)) {
            System.out.println("*******BROKEN********" + toString());
        }
    }

    public String toString() {
        return "No." + counter + " : " + name + "," + address;
    }
}
