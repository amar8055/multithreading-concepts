package org.example;

public class MultiThreadingWithSleepMain {
    public static void main(String[] args) {
        for(int i=0; i<2; i++) {
            MultiThreadingWithSleep multiThreadingWithSleep = new MultiThreadingWithSleep(i);
            Thread t1 = new Thread(multiThreadingWithSleep);
            t1.start();
        }
    }
}
