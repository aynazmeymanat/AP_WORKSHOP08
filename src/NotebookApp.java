import java.util.Scanner;

public class NotebookApp {
    public static void main(String[] args) {
        NoteBook notebook = new NoteBook();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nNotebook Menu:");
            System.out.println("1. Add Note");
            System.out.println("2. Remove Note");
            System.out.println("3. View Notes");
            System.out.println("4. Export Note");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
        }
    }