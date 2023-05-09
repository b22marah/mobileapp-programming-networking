package com.example.networking;

public class Mountain {
    private String ID;
    private String name;
    private String type;
    private String company;
    private String location;
    private String category;
    private int size;
    private int cost;
    private Auxdata auxdata;

    public Mountain(String name, int size, int cost) {
        this.name = name;
        this.size = size;
        this.cost = cost;
    }

    @Override
    public String toString() {
        String printMountain = name+" "+size+" "+cost+" ";
        return printMountain;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}