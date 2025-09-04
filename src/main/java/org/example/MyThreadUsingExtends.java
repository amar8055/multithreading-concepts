package org.example;

public class MyThreadUsingExtends extends Thread {
    @Override
    public void run() {
        System.out.println("Thread running: " +Thread.currentThread().getName());
    }
}
