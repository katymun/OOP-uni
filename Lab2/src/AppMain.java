import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) {
        Path folderPath = Paths.get("C:\\Users\\munka\\OneDrive\\Documents\\uni-git-projects\\OOP-uni\\testFolder");
        Scanner scanner = new Scanner(System.in);
        String command = "";
        FileManager fm = new FileManager(folderPath);
        System.out.println("Welcome!");


        while (command != "exit") {
            System.out.println("Choose one of the commands (commit, info <filename>, status, exit): ");
        }
    }

    public void printMenu() {
        System.out.println("Choose one of the commands (commit, info <filename>, status, exit): ");
    }
}
