package br.com.matheuspierro.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cashier {
    private Lock lock = new ReentrantLock();
    private Queue<Integer> queue = new LinkedList<>();

    public void serveCustomer(int customerId, ArrayList<String> products) throws InterruptedException {
        lock.lock();
        try {
            queue.add(customerId);
            while (!queue.peek().equals(customerId)) {
                lock.unlock();
                Thread.sleep(1000);
                lock.lock();
            }

            for (String product : products) {
                System.out.println("Cashier is serving customer " + customerId + " with product: " + product);
                Thread.sleep(3000);
            }
            queue.remove();
        } finally {
            lock.unlock();
        }
    }
}
