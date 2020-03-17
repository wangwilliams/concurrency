package com.wangyunpeng.concurrent.chapter2.chapter3;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void setState(int state) {
        if (state == this.state){
            return;
        }
        this.state = state;
        notifyAllObserver();
    }

    public void notifyAllObserver(){
        observers.stream().forEach(Observer::update);
    }
}
