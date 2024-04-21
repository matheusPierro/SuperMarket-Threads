package br.com.matheuspierro.models;

import java.util.ArrayList;
import java.util.Random;

public class Customer implements Runnable {
    private int id;
    private Shelf shelf;
    private Cashier cashier;
    private ArrayList<String> cart = new ArrayList<>();

    public Customer(int id, Shelf shelf, Cashier cashier) {
        this.id = id;
        this.shelf = shelf;
        this.cashier = cashier;
    }

    @Override
    public void run() {
        try {
            String[] possibleProducts = {"Product A", "Product B", "Product C"};
            Random random = new Random();

            for (int i = 0; i < 5; i++) {
                String chosenProduct = possibleProducts[random.nextInt(possibleProducts.length)];
                String product = shelf.pickProduct(chosenProduct);
                if (product != null) {
                    cart.add(product);
                    System.out.println("Customer " + id + " picked up the product: " + product);
                }
                Thread.sleep(2000);
            }
            cashier.serveCustomer(this.id, cart);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
