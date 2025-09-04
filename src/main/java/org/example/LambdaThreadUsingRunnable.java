package org.example;

public class LambdaThreadUsingRunnable {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Lambda Thread using runnable: " +Thread.currentThread().getName());
            }
        });
        t1.start();
    }
}
