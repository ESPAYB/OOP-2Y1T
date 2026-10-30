package com.mycompany.m1_simpledebug_hilario;

public class BorrowingDemo {
    public static void main(String[] args) {
        // Create one Book and two Member objects
        Book book = new Book("Effective Java");
        Member member1 = new Member("Alice");
        Member member2 = new Member("Bob");

        System.out.println("=== INITIAL STATE ===");
        member1.displayBorrowedBook();
        member2.displayBorrowedBook();

        System.out.println("\n=== TEST 1: First Borrowing Attempt ===");
        member1.borrow(book);
        member1.displayBorrowedBook();

        System.out.println("\n=== TEST 2: Second Borrowing Attempt (Double Borrowing) ===");
        member2.borrow(book);
        member2.displayBorrowedBook();
    }
}
