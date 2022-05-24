package com.onlineMaktab.domain;

public abstract class Readable extends Base{
    private String author;
    private String pageNumber;

    public Readable() {
    }

    public Readable(int id, String author, String pageNumber) {
        super(id);
        this.author = author;
        this.pageNumber = pageNumber;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }
}
