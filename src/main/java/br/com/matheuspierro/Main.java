package br.com.matheuspierro;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        SuperMarketList superMarketList = new SuperMarketList();

        for (int i = 0; i < 100; i++) {
            new Thread(new ThreadAddElement(superMarketList, i)).start();
        }

        Thread.sleep(2000);

        for(int i = 0; i <superMarketList.size(); i++) {
            System.out.println(superMarketList.pickElement(i));
        }

    }
}