import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReadWrite {
    public static void readFile(String saveFile) {        
        try {
            File f = new File("./../saves/" + saveFile);
            Scanner sc = new Scanner(f);
            
            sc.close();
        } catch(FileNotFoundException e) {
            System.out.println("Error loading save file.");
        }
    }

    public static void createFile() {
        try {
            int saveNumber = 1;
            File f;
            while(true) {
                f = new File("./../saves/save-" + saveNumber + ".txt");
                if(!f.createNewFile()) saveNumber++;
                else break;
            }

            System.out.println("New save file(" + f.getName() + ") successfully generated!");
        } catch(IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
 
    public static void saveFile() {

    }
}