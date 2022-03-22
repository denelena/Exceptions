package ru.netology.domain;

public class TShirt extends Product {
    private String color;
    private String size;

    public TShirt(int id, String name, int price, String color, String size){
        super(id, name, price);
        this.color = color;
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }
}
