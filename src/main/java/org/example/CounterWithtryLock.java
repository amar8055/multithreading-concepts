package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterWithtryLock {
    private int count = 0;
    private final Lock lock = new ReentrantLock();

    void increment() {
        if (lock.tryLock()) { // tryLock() is useful if you don't want a thread to be locked forever
            try {
            count++;
            } finally {
               lock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " couldn't get the lock");
        }
    }

    int getCount() {
        return count;
    }
}

