# Market Simulation with Java Threads

This project is a simple simulation of a market environment where customers are represented as concurrent threads, each trying to pick products from shelves and then queue up to pay at a cashier. The application demonstrates the use of threading, synchronization mechanisms, and concurrency control in Java.

## Features

### Customer
- Each customer runs on its own thread.
- Customers pick 5 random products from available shelves.
- If a product is unavailable, the customer skips it.
- After collecting products, customers go to the cashier to pay.
- If the cashier is busy, customers wait in a queue.

### Shelf
- Each shelf starts with 10 units of three different products.
- Access to products is synchronized to ensure that only one customer can pick a product at any given time.
- Products are decremented from the shelf as customers pick them.

### Cashier
- The cashier can serve only one customer at a time.
- Serving each product takes 3 seconds.
- Customers queue if the cashier is already serving another customer.

## Setup

### Requirements
- Java 11 or higher

### Running the Application
To run the application, compile the Java files and then run the `Market` class. This can be done from the command line as follows:

1. Compile the code:
   ```bash
   javac Market.java Customer.java Shelf.java Cashier.java

2. Run the program:
   ```bash
    java Market

### Code Structure
- Shelf.java: Contains logic for managing products on a shelf with synchronization.
- Customer.java: Defines the customer behavior, picking products and paying for them.
- Cashier.java: Manages the queue of customers and processes each customer's products.
- Market.java: Initializes the simulation with a set number of customers, a shelf, and a cashier.

### Concurrency Control
- The Shelf class uses a ReentrantLock to synchronize access to the product list.
- The Cashier class uses another ReentrantLock to manage customer queue and ensure that only one customer is served at a time.

### Future Enhancements
- Improve product selection logic to handle more diverse and complex scenarios.
- Add more detailed simulation aspects, such as multiple cashiers and different types of shelves.
- Implement a GUI to visualize the market simulation in real-time.