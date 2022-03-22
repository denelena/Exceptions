package ru.netology.domain;

public class Book extends Product {
    private String author;
    private int pages;
    private int publishedYear;

    public Book(int id, String name, int price, String author, int pages, int publishedYear){
        super(id, name, price);
        this.author = author;
        this.pages = pages;
        this.publishedYear = publishedYear;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public int getPublishedYear() {
        return publishedYear;
    }
}