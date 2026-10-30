package com.mycompany.m1_simpledebug_hilario;

public class Book {
    private String title;
    private boolean available;

    public Book(String title) {
        this.title = title;
        this.available = true; // Book is available by default when created
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}