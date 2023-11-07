import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) {
        String path = "C:\\Users\\munka\\OneDrive\\Documents\\uni-git-projects\\OOP-uni\\testFolder\\";
        Path folderPath = Paths.get(path);

        Scanner scanner = new Scanner(System.in);
        String[] command = {"welcome"};
        FileManager fm = new FileManager(path);
        System.out.println("Welcome!");

//        fm.addSnapshot("ex.txt");
//        fm.addSnapshot("photo1.jpg");
//        fm.addSnapshot("SQLS.java");

        while (!command[0].equals("exit")) {
            System.out.print("Choose one of the commands (commit, info <filename>, status, exit): ");
            command = scanner.nextLine().trim().split(" ");
            switch (command[0]) {
                case "commit": fm.commit(); break;
                case "info": fm.printFileInfo(command[1]); break;
                case "status": fm.printStatus(); break;
                case "exit": System.exit(0);
            }

        }
    }

}
