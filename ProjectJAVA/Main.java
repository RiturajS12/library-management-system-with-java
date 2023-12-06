import secondpackage.LibrarySystem;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibrarySystem librarySystem = new LibrarySystem();

        int choice;
        do {
            displayMenu();
            choice = sc.nextInt();
            librarySystem.processChoice(choice, sc);
        } while (choice != 3);

        System.out.println("Exited");
        sc.close();
    }

    private static void displayMenu() {
        System.out.println("Enter your choice:");
        System.out.println("1. Create user\n2. Login\n3. Exit");
    }
}
