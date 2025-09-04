package org.example;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterWithTryLockAndTimeout {
    private int count = 0;
    private final Lock lock = new ReentrantLock();

    void increment() throws InterruptedException {
        if (lock.tryLock(500, TimeUnit.MILLISECONDS)) {
            try {
                count++;
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " Timeout waiting for lock");
        }
    }

    int getCount() {
        return count;
    }
}
