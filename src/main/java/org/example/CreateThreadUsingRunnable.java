package org.example;

public class CreateThreadUsingRunnable {
    public static void main(String[] args) {
        // There are 2 ways to create a Thread
        // One is Extending Thread class
        // other way is by Implementing runnable interface
        Thread t1 = new Thread(new MyTask());
        t1.start();

    }

    static class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running");
        }
    }
}
