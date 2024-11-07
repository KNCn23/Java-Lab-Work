package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Create books with 2 copies each
        Book book1 = new Book("The Catcher in the Rye", "J.D. Salinger", "12345", 2);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "67890", 2);
        Book book3 = new Book("1984", "George Orwell", "11111", 2);
        Book book4 = new Book("Pride and Prejudice", "Jane Austen", "22222", 2);
        Book book5 = new Book("Moby Dick", "Herman Melville", "33333", 2);

        // Add books to library collection
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        // Create members
        Member member1 = new Member("Alice", "M001");
        Member member2 = new Member("Bob", "M002");
        Member member3 = new Member("Charlie", "M003");

        // Create a librarian
        Librarian librarian = new Librarian("Tom", "L001");

        // Display initial inventory
        System.out.println("Initial Library Inventory:");
        librarian.displayBooks(books);

        // Members trying to borrow the same book to test error handling
        System.out.println("\nMembers borrowing the same book:");
        member1.borrowBook(book1); // Should succeed
        member2.borrowBook(book1); // Should succeed
        member3.borrowBook(book1); // Should fail, showing current borrowers

        // Try returning the book
        System.out.println("\nReturning books:");
        member1.returnBook(book1); // Should succeed
        member3.returnBook(book1); // Should fail, as member3 didn't borrow the book

        // Librarian adding copies to an existing book
        System.out.println("\nLibrarian adding more copies of a book:");
        librarian.addBook(book1, books, 3); // Adds 3 more copies to "The Catcher in the Rye"

        // Librarian tries adding a completely new book
        Book book6 = new Book("War and Peace", "Leo Tolstoy", "44444", 0);
        librarian.addBook(book6, books, 2); // Adds "War and Peace" with 2 copies

        System.out.println("\nLibrarian removing copies of a book:");
        librarian.removeCopies(book4, 1); // Removes 1 copies from "Pride and Prejudice"

        // Librarian removing all copies of a specific book
        System.out.println("\nLibrarian completely removing a book from inventory:");
        librarian.removeAllCopies(book3, books);


        // Display final inventory
        System.out.println("\nUpdated Library Inventory:");
        librarian.displayBooks(books);
    }
}