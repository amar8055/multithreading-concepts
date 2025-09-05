package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Logger;

public class ProducerAndConsumerThreadCommunication {
    Logger logger = Logger.getLogger(ProducerAndConsumerThreadCommunication.class.getName());
    int capacity;
    Queue<Integer> queue = new LinkedList<>();

    public synchronized void producer(int value) throws InterruptedException {
        while(queue.size() == capacity){
            //wait until some space is available
          wait();
        }
        queue.add(value);
        logger.info("Produced: " + value);
        notifyAll(); //notify the consumer that an item is available
    }

    public synchronized void consumer() throws InterruptedException {
        while (queue.isEmpty()) {
            //wait until an item is available
            wait();
        }
      int value = queue.poll();
      logger.info("Consumed: " + value);
      notifyAll(); //notify the producer that space is available
    }

    public ProducerAndConsumerThreadCommunication(int capacity) {
        this.capacity = capacity;
    }

    public ProducerAndConsumerThreadCommunication() {
    }

    public static void main(String[] args) {
        ProducerAndConsumerThreadCommunication pc = new ProducerAndConsumerThreadCommunication(5);
        // You can create producer and consumer threads here to test the implementation
        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    pc.producer(i);
                    Thread.sleep(100); // Simulate time taken to produce an item
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    pc.consumer();
                    Thread.sleep(150); // Simulate time taken to consume an item
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
