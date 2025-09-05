package org.example;

public class MultiThreadingWithSleep implements Runnable {

    private final int threadNumber;
    public MultiThreadingWithSleep(int threadNumber){
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for (int i=0; i<=5; i++) {
            System.out.println(i +" from which Thread "+ threadNumber);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
