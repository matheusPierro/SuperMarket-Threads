package br.com.matheuspierro;

import br.com.matheuspierro.models.Cashier;
import br.com.matheuspierro.models.Customer;
import br.com.matheuspierro.models.Shelf;

public class Market {
    public static void main(String[] args) {
        Shelf shelf = new Shelf();
        Cashier cashier = new Cashier();

        for (int i = 1; i <= 10; i++) { // Suppose we have 10 customers
            Customer customer = new Customer(i, shelf, cashier);
            Thread customerThread = new Thread(customer);
            customerThread.start();
        }
    }
}
