package com.example.s12.model;

public class Book {
    private int id;
    private String tittle;
    private int pageSize;
    private int author;
    private int category;

    public Book() {
    }

    public Book(int id, String tittle, int pageSize, int author, int category) {
        this.id = id;
        this.tittle = tittle;
        this.pageSize = pageSize;
        this.author = author;
        this.category = category;
    }

    public Book(String tittle, int pageSize, int author, int category) {
        this.tittle = tittle;
        this.pageSize = pageSize;
        this.author = author;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
