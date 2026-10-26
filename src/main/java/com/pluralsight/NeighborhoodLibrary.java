
package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {

    private static int numBooks = 3;
    private static int numCheckedOut = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Book[] book = new Book[20];

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
            return;
        }

        if (book[pick-1].id() != 0 && !book[pick-1].isCheckedOut) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            book[pick-1].isCheckedOut = true;
            numCheckedOut += 1;
            book[pick-1].setName(name);
            System.out.println(book[pick-1].title + " is checked out to " + name);

        } else {
            System.out.println("Invalid choice or book already checked out.");
        }
    }
//End of checking out a book

    public static void returnBook(Scanner kd, Book[] book) {

        for (int i = 0; i < numBooks; i++) {
            if (book[i].isCheckedOut) {
                System.out.println("ID  ISBN                Title");
                System.out.println(book[i].id + "   " + book[i].isbn + "   " + book[i].title);


            }
        }
            System.out.println("What book id was it? ");
            int pick = kd.nextInt();

            if (pick == 0) {
                System.out.println("You chose to go back.");
                System.out.println("Going back to the home page");
            }
            else if (book[pick - 1].id() != 0 && book[pick - 1].isCheckedOut) {
                System.out.println("Thank you for returning " + book[pick - 1].title);
                book[pick - 1].isCheckedOut = false;
                numCheckedOut -= 1;
            }
    }//End of return book
}

