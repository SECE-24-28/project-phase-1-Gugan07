/**
 * Scene class
 * Represents a scene with title, characters, and dialogues.
 * (Array-based implementation without List/Collection)
 */
public class Scene {
    private String title;
    private String[] characters;
    private String[] dialogues;
    private int charCount;
    private int dialogueCount;

    // Constructor
    public Scene(String title) {
        this.title = title;
        this.characters = new String[20];   // max 20 characters
        this.dialogues = new String[100];   // max 100 dialogues
        this.charCount = 0;
        this.dialogueCount = 0;
    }

    // Add character
    public void addCharacter(String character) {
        if (character == null || character.trim().isEmpty()) {
            System.out.println("Character name cannot be empty!");
            return;
        }
        if (charCount < characters.length) {
            characters[charCount++] = character;
        } else {
            System.out.println("Cannot add more characters (limit reached).");
        }
    }

    // Add dialogue
    public void addDialogue(String character, String dialogue) {
        if (dialogueCount < dialogues.length) {
            dialogues[dialogueCount++] = character + ": " + dialogue;
        } else {
            System.out.println("Cannot add more dialogues (limit reached).");
        }
    }

    // Get title
    public String getTitle() {
        return title;
    }

    // Display scene content (instead of using List/returning array directly)
    public void displayScene() {
        System.out.println("Scene Title: " + title + "\n");

        System.out.println("Characters:");
        for (int i = 0; i < charCount; i++) {
            System.out.println("- " + characters[i]);
        }

        System.out.println("\nDialogues:");
        for (int i = 0; i < dialogueCount; i++) {
            System.out.println(dialogues[i]);
        }
    }

    // Convert scene to string (for saving in file)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Scene Title: ").append(title).append("\n\n");

        sb.append("Characters:\n");
        for (int i = 0; i < charCount; i++) {
            sb.append("- ").append(characters[i]).append("\n");
        }

        sb.append("\nDialogues:\n");
        for (int i = 0; i < dialogueCount; i++) {
            sb.append(dialogues[i]).append("\n");
        }

        return sb.toString();
    }
}
