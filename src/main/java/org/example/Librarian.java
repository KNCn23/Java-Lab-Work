package org.example;
import java.util.ArrayList;

public class Librarian extends Member {

    public Librarian(String name, String memberId) {
        super(name, memberId);
    }

    public ArrayList<String> viewBorrowedBooks() {
        return borrowedBooks;
    }

    public boolean returnBook(Book book) {
        return super.returnBook(book);
    }

    public boolean borrowBook(Book book) {
        return super.borrowBook(book);
    }

    // Add copies if book already exists; otherwise, add new book to inventory
    public void addBook(Book book, ArrayList<Book> books, int copiesToAdd) {
        if (books.contains(book)) {
            book.addCopies(copiesToAdd); // Add copies to an existing book
        } else {
            books.add(book); // Add new book to inventory
            book.addCopies(copiesToAdd - book.getTotalCopies()); // Set initial copies to desired amount
            System.out.println("Book " + book.getTitle() + " added to inventory with " + book.getTotalCopies() + " copies.");
        }
    }

    // Remove a specified number of copies of a book
    public void removeCopies(Book book, int copiesToRemove) {
        if (book.getAvailableCopies() >= copiesToRemove) {
            book.addCopies(-copiesToRemove);
            System.out.println(copiesToRemove + " copies of " + book.getTitle() + " removed from inventory. Remaining copies: " + book.getAvailableCopies());
        } else {
            System.out.println("Only " + book.getAvailableCopies() + " copies available. Removing all available copies.");
            book.addCopies(-book.getAvailableCopies());
        }
    }

    // Remove the book entirely from inventory
    public void removeAllCopies(Book book, ArrayList<Book> books) {
        if (books.contains(book)) {
            books.remove(book);
            System.out.println("Book " + book.getTitle() + " completely removed from inventory.");
        } else {
            System.out.println("Book " + book.getTitle() + " not found in inventory.");
        }
    }

    public void displayBooks(ArrayList<Book> books) {
        System.out.println("\nLibrary Book List:");
        for (Book book : books) {
            book.displayBook();
        }
    }
}