package org.example;
import java.util.ArrayList;

import java.util.ArrayList;

public class Member {
    private String name;
    private String memberId;
    protected ArrayList<String> borrowedBooks;

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
    }

    public boolean borrowBook(Book book) {
        if (borrowedBooks.contains(book.getISBN())) {
            System.out.println("Error: " + name + " has already borrowed this book.");
            return false;
        } else if (book.borrowBook(memberId, name)) {
            borrowedBooks.add(book.getISBN());
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        if (borrowedBooks.contains(book.getISBN()) && book.returnBook(memberId)) {
            borrowedBooks.remove(book.getISBN());
            return true;
        }
        System.out.println("Error: " + name + " did not borrow this book.");
        return false;
    }

    public ArrayList<String> viewBorrowedBooks() {
        return borrowedBooks;
    }

    // Getters for name and memberId
    public String getName() { return name; }
    public String getMemberId() { return memberId; }
}