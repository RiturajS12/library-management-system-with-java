package secondpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibrarySystem {
    private List<Library> users;
    private List<Book> availableBooks;

    public LibrarySystem() {
        this.users = new ArrayList<>();
        this.availableBooks = new ArrayList<>();
    }

    public void processChoice(int choice, Scanner sc) {
        switch (choice) {
            case 1:
                createUser(sc);
                break;
            case 2:
                login(sc);
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void createUser(Scanner sc) {
        System.out.println("---Creating user---");
        sc.nextLine();
        System.out.println("Enter username:");
        String username = sc.nextLine();
        if (!usernameExists(username)) {
            System.out.println("Enter password:");
            String password = sc.nextLine();
            Library newUser = new Library(username, password);
            users.add(newUser);
            System.out.println("User created successfully.");
        } else {
            System.out.println("Username already exists. Please try another username.");
        }
    }

    private boolean usernameExists(String username) {
        for (Library existingUser : users) {
            if (username.equals(existingUser.getUsername())) {
                return true;
            }
        }
        return false;
    }

    private void login(Scanner sc) {
        System.out.println("Enter username for login:");
        sc.nextLine();
        String loginUsername = sc.nextLine();
        System.out.println("Enter password for login:");
        String loginPassword = sc.nextLine();
        boolean loginSuccessful = false;
        for (Library user : users) {
            if (loginUsername.equals(user.getUsername()) && loginPassword.equals(user.getPassword())) {
                System.out.println("Login successful");
                loginSuccessful = true;
                System.out.println("Enter your choice:");
                System.out.println("1. Add book\n2. Delete a book\n3. Rent a book\n4. Login prompt");
                int choices = sc.nextInt();
                while (choices != 4) {
                        if (choices == 1) {
                                System.out.println("Available Books in Library:");
                                for (Book book : availableBooks) {
                                    System.out.println(book.getBookName() + " by " + book.getAuthor() + " with the code " + book.getBookCode());
                                }
                                if (availableBooks.isEmpty()) {
                                    System.out.println("There's no book available for purchase. Please first add a book.");
                                } else {
                                System.out.println("---Adding book---");
                                sc.nextLine();
                                System.out.println("Enter author:");
                                String author = sc.nextLine();
                                System.out.println("Enter book name:");
                                String bookName = sc.nextLine();
                                System.out.println("Enter book code:");
                                String bookCode = sc.nextLine();
                                boolean bookCodeExists = false;
                                for (Book book : availableBooks) {
                                    if (bookCode.equals(book.getBookCode())) {
                                        System.out.println("Book with code " + bookCode + " already exists. Book not added.");
                                        bookCodeExists = true;
                                        break;
                                    
                                    }
                                }
                                if (!bookCodeExists) {
                                    Book newBook = new Book(author, bookName, bookCode);
                                    availableBooks.add(newBook);
                                    System.out.println("Book added successfully.");
                                }
                            }
                            } else if (choices == 2) {
                                System.out.println("Available Books for Purchase:");
                                for (Book book : availableBooks) {
                                    System.out.println(book.getBookName() + " by " + book.getAuthor() + " with the code " + book.getBookCode());
                                }
                                if (availableBooks.isEmpty()) {
                                    System.out.println("There's no book available for purchase. Please first add a book.");
                                } else {
                                    System.out.println("Enter book name to delete:");
                                    sc.nextLine();  
                                    String bookToDelete = sc.nextLine();
                                    boolean bookFound = false;
                                    for (Book book : availableBooks) {
                                        if (bookToDelete.equals(book.getBookName())) {
                                            System.out.println("Book found: " + book.getBookName() + " by " + book.getAuthor() + " with the code " + book.getBookCode());
                                            availableBooks.remove(book);
                                            System.out.println("Book deleted successfully.");
                                            bookFound = true;
                                            break;
                                        }
                                    }
                                    if (!bookFound) {
                                        System.out.println("Book not found, please try again.");
                                    }
                                }
                            } else if (choices == 3) {
                                if (availableBooks.isEmpty()) {
                                    System.out.println("There's no book here, Please first add a book");
                                } else {
                                    System.out.println("Available Books for Rent:");
                                    for (Book book : availableBooks) {
                                        System.out.println(book.getBookName() + " by " + book.getAuthor() + " with the code " + book.getBookCode());
                                    }
                                    System.out.println("Enter the book name to rent:");
                                    sc.nextLine();
                                    String bookToRent = sc.nextLine();
                                    boolean bookFound = false;
                                    for (Book book : availableBooks) {
                                        if (bookToRent.equals(book.getBookName())) {
                                            System.out.println("Book rented: " + book.getBookName() + " by " + book.getAuthor() +
                                                    " with the code " + book.getBookCode() + " for 30 days. ");
                                            availableBooks.remove(book);
                                            bookFound = true;
                                            break;
                                        }
                                    }
                                    if (!bookFound) {
                                        System.out.println("Book not found, please try again.");
                                    }
                                }
                            } else if(choices == 4){
                                System.out.println("Exited to login prompt.");
                            }
                            System.out.println("Enter your choice:");
                            System.out.println("1. Add book\n2. Delete a book\n3. Rent a book");
                            choices = sc.nextInt();
                        }
                        break;
                    }
                }
        if (!loginSuccessful) {
            System.out.println("Login failed. Please try again.");
        }
    }
}
