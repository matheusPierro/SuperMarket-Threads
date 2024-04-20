package br.com.matheuspierro;

public class SuperMarketList {
    private String[] elements = new String[1000];
    private int index = 0;

    public synchronized void addElements(String element) {
        this.elements[index] = element;
        this.index++;
    }

    public int size() {
        return this.elements.length;
    }

    public String pickElement(int position) {
        return this.elements[position];
    }
}