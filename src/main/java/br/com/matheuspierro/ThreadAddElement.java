package br.com.matheuspierro;

public class ThreadAddElement implements Runnable {

    private SuperMarketList superMarketList;
    private int threadNumber;

    public ThreadAddElement(SuperMarketList superMarketList, int threadNumber) {
        this.superMarketList = superMarketList;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            superMarketList.addElements("Thread " + threadNumber + " - " + i);
        }
    }
}