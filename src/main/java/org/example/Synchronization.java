package org.example;

public class Synchronization {

    //when multiple threads access and modify the same shared resources, they may interfere
    // with each other. This creates race condition --> unpridictable results

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        CounterWithSynchronized counterWithSynchronized = new CounterWithSynchronized();

        Thread t1 = new Thread(() -> {
            for (int i=0; i<1000; i++) {
             counter.increment();
             counterWithSynchronized.increment();
            }
        });

        t1.start();
        t1.join(); // If you dont specify .join() you might see output as 0. Because
        // Thread doesn't wait and by the time program executed Thread might not
        // have started at all

        Thread t2 = new Thread(() -> {
           for (int i=0;i<1000;i++) {
            counter.increment();
            counterWithSynchronized.increment();
           }
        });

        t2.start();
        t2.join();

        System.out.println("Final Count = " +counter.getCount());
        System.out.println("Final Count = " +counterWithSynchronized.getCount());
    }
}
