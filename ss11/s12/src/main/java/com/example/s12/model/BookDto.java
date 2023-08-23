package com.example.s12.model;

public class BookDto {
    private int id;
    private String title;
    private int pageSize;
    private String nameAuthor;
    private String nameCategory;

    public BookDto() {
    }

    public BookDto(int id, String title, int pageSize, String nameAuthor, String nameCategory) {
        this.id = id;
        this.title = title;
        this.pageSize = pageSize;
        this.nameAuthor = nameAuthor;
        this.nameCategory = nameCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}