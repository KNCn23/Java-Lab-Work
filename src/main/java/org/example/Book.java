package org.example;

import java.util.ArrayList;

public class Book {
    private String title;
    private String author;
    private String ISBN;
    private int totalCopies;
    private int availableCopies;
    private ArrayList<String> currentBorrowers;

    public Book(String title, String author, String ISBN, int totalCopies) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
        this.currentBorrowers = new ArrayList<>();
    }

    public boolean borrowBook(String memberId, String memberName) {
        if (currentBorrowers.contains(memberId)) {
            System.out.println("Error: Member " + memberName + " has already borrowed this book.");
            return false;
        } else if (availableCopies > 0) {
            availableCopies--;
            currentBorrowers.add(memberId);
            System.out.println("Book borrowed by member " + memberName);
            return true;
        } else {
            System.out.println("Error: No copies of " + title + " are available. Book is currently borrowed by:");
            for (String borrower : currentBorrowers) {
                System.out.println(" - Member ID: " + borrower);
            }
            return false;
        }
    }

    public boolean returnBook(String memberId) {
        if (currentBorrowers.contains(memberId)) {
            availableCopies++;
            currentBorrowers.remove(memberId);
            System.out.println("Book returned by member ID: " + memberId);
            return true;
        } else {
            System.out.println("Error: This member didn't borrow this book.");
            return false;
        }
    }

    public void addCopies(int count) {
        if (count > 0) {
            totalCopies += count;
            availableCopies += count;
            System.out.println(count + " copies of " + title + " have been added. Total copies: " + totalCopies);
        } else if (count < 0) {
            int removedCopies = Math.min(-count, availableCopies); // Prevent removing more than available
            totalCopies -= removedCopies;
            availableCopies -= removedCopies;
            System.out.println(removedCopies + " copies of " + title + " have been removed. Remaining copies: " + availableCopies);
        }
    }

    public void displayBook() {
        System.out.println("Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", Available Copies: " + availableCopies + "/" + totalCopies);
    }

    // Getters for additional access
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getISBN() { return ISBN; }
    public int getTotalCopies() { return totalCopies; }
    public int getAvailableCopies() { return availableCopies; }
}