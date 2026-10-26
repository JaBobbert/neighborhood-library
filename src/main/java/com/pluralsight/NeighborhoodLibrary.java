
package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {

    private static int numBooks = 3;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Book[] book = new Book[10];

        book[0] = new Book(1, "657-1-25-000001-0", "Cat and The Hat");
        book[1] = new Book(2, "657-1-25-000002-0", "TMNT");
        book[2] = new Book(3, "657-1-25-000003-0", "Batman vs Superman");

        boolean isDone = false;
        int choice;

        System.out.println("Welcome to the library.");

        while (!isDone) {
            System.out.println("-------------Home Screen-------------");
            System.out.println(" 1 - Show Available Books");
            System.out.println(" 2 - Check Out Books");
            System.out.println(" 3 - Return checked out Book");
            System.out.println(" 4 - Exit");
            System.out.print("Choose an option: ");

            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    displayAllBooks(book);
                    break;

                case 2:
                    checkOutBook(scan, book);
                    break;

                case 3:
                    returnBook(scan, book);
                    break;

                case 4:
                    System.out.println("Have a Good Day");
                    System.out.println("Goodbye!");
                    isDone = true;
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        }

        scan.close();
    }

    public static void displayAllBooks(Book[] book) {
        System.out.println("ID  ISBN                Title");

        for (int i = 0; i < numBooks; i++) {
            if (!book[i].isCheckedOut) {
                System.out.println(book[i].id + "   " + book[i].isbn + "   " + book[i].title);
            }
        }
    }//End of display all books

    public static void checkOutBook(Scanner scanner, Book[] book) {

        System.out.println("ID  ISBN                Title");

        for (int i = 0; i < numBooks; i++) {
            if (!book[i].isCheckedOut) {
                System.out.println(book[i].id + "   " + book[i].isbn + "   " + book[i].title);
            }
        }

        System.out.print("Enter an ID to check out, or 0 to go back: ");
        int pick = scanner.nextInt();
        scanner.nextLine();

        if (pick == 0) {
            System.out.println("You chose to go back.");
            System.out.println("Going back to the home page");
        }

        for (int i = 0; i < numBooks; i++) {
            if (pick == book[i].id && !book[i].isCheckedOut) {
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();

                book[i].setName(name);
                System.out.println(book[i].title + " is checked out to " + name);
                book[i].isCheckedOut = true;
            }

            else {
                System.out.println("Invalid choice or book already checked out.");
            }
        }


        System.out.println("Going back to the home page");
    }//End of checking out a book

    public static void returnBook(Scanner kd, Book[] book){
        System.out.println("Hello may you present your name: ");
        String name = kd.nextLine();

        for(int i = 0; i < numBooks; i++) {
            if (name.equalsIgnoreCase(book[i].getName())) {
                System.out.println("Would you like to return this book " + book[i]);
                System.out.println("1 for yes. 2 for no.");
                int pick = kd.nextInt();
                if (pick == 1) {
                    System.out.println("Thank you for returning this book " + book[i]);
                    book[i].isCheckedOut = false;
                } else if (pick == 2) {
                    System.out.println("Okay take as long as you need with the book.");
                } else {
                    System.out.println("Sorry invalid choice. You will be sent back to the home page.");
                }
            } else {
                System.out.println("Sorry " + name + " is not currently having a book checked out at this time.");
            }
        }
    }//End of return book
}
