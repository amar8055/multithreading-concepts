package org.example;

public class LockDemoMain {
    public static void main(String[] args) throws InterruptedException {
        CounterWithLocalAPI counterWithLocalAPI = new CounterWithLocalAPI();
        CounterWithtryLock counterWithtryLock = new CounterWithtryLock();
        CounterWithTryLockAndTimeout counterWithTryLockAndTimeout = new CounterWithTryLockAndTimeout();

        Thread t1 = new Thread(() -> {
            for (int i=0; i<1000; i++) {
             counterWithLocalAPI.increment();
             counterWithtryLock.increment();
                try {
                    counterWithTryLockAndTimeout.increment();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t1.join();

        System.out.println("Final count = " +counterWithLocalAPI.getCount());
        System.out.println("Final count = " +counterWithtryLock.getCount());
        System.out.println("Final count = " +counterWithTryLockAndTimeout.getCount());
    }
}
