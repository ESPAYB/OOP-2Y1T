package com.mycompany.m1_simpledebug_hilario;

public class Member {
    private String name;
    private Book borrowedBook; // Object reference establishing Has-A association

    public Member(String name) {
        this.name = name;
        this.borrowedBook = null;
    }

    public String getName() {
        return this.name;
    }

    public boolean borrow(Book book) {
        if (book.isAvailable()) {
            this.borrowedBook = book;
            book.setAvailable(false);
            System.out.printf("%s successfully borrowed '%s'.%n", this.name, book.getTitle());
            return true;
        } else {
            System.out.printf("Borrow attempt failed: '%s' is currently unavailable for %s.%n", 
                              book.getTitle(), this.name);
            return false;
        }
    }

    public void displayBorrowedBook() {
        if (borrowedBook != null) {
            System.out.printf("Member: %s | Borrowed Book: '%s'%n", this.name, borrowedBook.getTitle());
        } else {
            System.out.printf("Member: %s | Borrowed Book: None%n", this.name);
        }
    }
}
