import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NoteBook {
    private List<Note> notes;

    public NoteBook() {
        notes = new ArrayList<>();

    }

    public static void addNote() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the name of the note (or 'back' to return to menu): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("back")) {
                return;
            }
            System.out.print("Enter the content of the note (or 'back' to return to menu): ");
            String content = scanner.nextLine();
            if (content.equalsIgnoreCase("back")) {
                return;
            }
            notes.add(new Note(name, content));
            System.out.println("Note added successfully.");
            return;
        }
    }

    public static void removeNote() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (notes.isEmpty()) {
                System.out.println("No notes available to remove.");
                return;
            }

            displayNotes();
            System.out.print("Enter the number of the note to remove (or 'back' to return to menu): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("back")) {
                return;
            }
            try {
                int index = Integer.parseInt(input);
                if (index < 1 || index > notes.size()) {
                    System.out.println("Invalid note number.");
                } else {
                    notes.remove(index - 1);
                    System.out.println("Note removed successfully.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public static void viewNotes() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (notes.isEmpty()) {
                System.out.println("No notes available.");
                return;
            }

            displayNotes();
            System.out.print("Enter the number of the note to view (or 'back' to return to menu): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("back")) {
                return;
            }
            try {
                int index = Integer.parseInt(input);
                if (index < 1 || index > notes.size()) {
                    System.out.println("Invalid note number.");
                } else {
                    Note note = notes.get(index - 1);
                    System.out.println("Content of the note:");
                    System.out.println(note.getContent());
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public static void exportNote() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (notes.isEmpty()) {
                System.out.println("No notes available to export.");
                return;
            }

            displayNotes();
            System.out.print("Enter the number of the note to export (or 'back' to return to menu): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("back")) {
                return;
            }
            try {
                int index = Integer.parseInt(input);
                if (index < 1 || index > notes.size()) {
                    System.out.println("Invalid note number.");
                } else {
                    Note note = notes.get(index - 1);
                    try (FileWriter writer = new FileWriter(note.getName() + ".txt")) {
                        writer.write(note.getContent());
                        System.out.println("Note exported successfully to " + note.getName() + ".txt");
                        return;
                    } catch (IOException e) {
                        System.out.println("An error occurred while exporting the note.");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private void displayNotes() {
        System.out.println("\nExisting Notes:");
        for (int i = 0; i < notes.size(); i++) {
            System.out.println((i + 1) + ". " + notes.get(i));
        }
    }
}
