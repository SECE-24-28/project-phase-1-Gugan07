import java.util.*;
import java.io.*;

/**
 * Main class for Dialogue Script Writer
 * Provides menu options to create and view scenes.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // Menu display
            System.out.println("\n=== Dialogue Script Writer Menu ===");
            System.out.println("1. Create New Scene");
            System.out.println("2. View Scene");
            System.out.println("3. Exit");
            System.out.print("Select option: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    createScene(sc);
                    break;
                case 2:
                    System.out.print("Enter scene title to view: ");
                    String title = sc.nextLine();
                    try {
                        SceneManager.viewScene(title);
                    } catch (Exception e) {
                        System.out.println("Scene not found.");
                    }
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Method to create a new scene
    public static void createScene(Scanner sc) {
        System.out.print("Enter scene title: ");
        String title = sc.nextLine();

        Scene scene = new Scene(title);

        // Adding characters
        System.out.print("Enter number of characters: ");
        int numChars = 0;
        try {
            numChars = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number. Defaulting to 0.");
        }

        for (int i = 0; i < numChars; i++) {
            System.out.print("Enter character name: ");
            scene.addCharacter(sc.nextLine());
        }

        // Adding dialogues
        System.out.println("\nEnter dialogues (type 'end' as character name to finish):");
        while (true) {
            System.out.print("Character: ");
            String charName = sc.nextLine();
            if (charName.equalsIgnoreCase("end")) break;

            System.out.print("Dialogue: ");
            String dialogue = sc.nextLine();
            scene.addDialogue(charName, dialogue);
        }

        // Save scene to file
        try {
            SceneManager.saveSceneToFile(scene);
            System.out.println("Scene saved successfully!");
        } catch (Exception e) {
            System.out.println("Error saving scene: " + e.getMessage());
        }
    }
}
