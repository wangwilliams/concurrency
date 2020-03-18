package com.wangyunpeng.concurrent.chapter2.chapter5;

public class Client {
    public static void main(String[] args) {
        Gate gate = new Gate();
        User bj = new User("Baobao", "Beijing", gate);
        User sh = new User("Shang", "Shanghai", gate);
        User gd = new User("Guanglao", "Guangdong", gate);
        bj.start();
        sh.start();
        gd.start();
    }
}
