package br.com.matheuspierro.models;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.HashMap;

public class Shelf {
    private Lock lock = new ReentrantLock();
    private HashMap<String, Integer> products = new HashMap<>();

    public Shelf() {
        products.put("Product A", 20);
        products.put("Product B", 20);
        products.put("Product C", 20);
    }

    public String pickProduct(String product) {
        lock.lock();
        try {
            if (products.get(product) > 0) {
                products.put(product, products.get(product) - 1);
                return product;
            } else {
                System.out.println("Product unavailable");
                return null;
            }
        } finally {
            lock.unlock();
        }
    }
}
