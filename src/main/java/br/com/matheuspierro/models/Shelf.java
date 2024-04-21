package br.com.matheuspierro.models;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.HashMap;

public class Shelf {
    private Lock lock = new ReentrantLock();
    private HashMap<String, Integer> products = new HashMap<>();

    public Shelf() {
        // Initialize each shelf with 10 units of each product
        products.put("Product A", 10);
        products.put("Product B", 10);
        products.put("Product C", 10);
    }

    public String pickProduct(String product) {
        lock.lock();
        try {
            if (products.get(product) > 0) {
                products.put(product, products.get(product) - 1);
                return product;
            } else {
                return null; // Product unavailable
            }
        } finally {
            lock.unlock();
        }
    }
}
