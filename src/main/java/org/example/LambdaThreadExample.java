package org.example;

public class LambdaThreadExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(()-> {
            System.out.println("Lambda Thread running: " +Thread.currentThread().getName());
        });
        t1.start();
    }
}
