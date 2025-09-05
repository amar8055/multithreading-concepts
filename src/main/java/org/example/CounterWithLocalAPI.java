package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterWithLocalAPI {
    private int count = 0;
    private final Lock lock = new ReentrantLock();
    void increment() {
        lock.lock(); // acquire the lock
        try {
            count++; //critical section
        } finally {
            lock.unlock(); // always release the lock
        }
    }

    int getCount() {
        return count;
    }
}
