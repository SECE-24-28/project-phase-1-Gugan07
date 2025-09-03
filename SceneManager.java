import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * SceneManager class
 * Demonstrates:
 * - Aggregation (SceneManager uses Scene)
 * - File Handling (I/O classes)
 */
public class SceneManager {
    private Scene[] scenes;
    private int sceneCount;

    public SceneManager() {
        scenes = new Scene[10]; // can store 10 scenes
        sceneCount = 0;
    }

    // Add a scene
    public void addScene(Scene scene) {
        if (sceneCount < scenes.length) {
            scenes[sceneCount++] = scene;
        } else {
            System.out.println("Scene limit reached!");
        }
    }

    // Display all scenes
    public void displayAllScenes() {
        for (int i = 0; i < sceneCount; i++) {
            scenes[i].displayScene();
        }
    }

    // Save all scenes to file
    public void saveToFile(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < sceneCount; i++) {
                bw.write(scenes[i].toString());
                bw.newLine();
            }

            bw.close();
            fw.close();
            System.out.println("Script saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
