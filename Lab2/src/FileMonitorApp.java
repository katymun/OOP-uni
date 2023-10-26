import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileMonitorApp {
    private Map<String, FileSnapshot> fileSnapshots = new HashMap<>();
    private Map<String, FileSnapshot> changedFiles = new HashMap<>();
    private Date snapshotTime;

    public void addFile(String filePath) {
        FileSnapshot snapshot = new FileSnapshot(filePath);
        fileSnapshots.put(snapshot.getFileName(), snapshot);
    }

    public void commit() {
        if (changedFiles.isEmpty()) {
            System.out.println("No changes to commit.");
        } else {
            snapshotTime = new Date();
            System.out.println("Commit successful. Files changed:");
            for (String filename : changedFiles.keySet()) {
                System.out.println(filename);
            }
            changedFiles.clear(); // Clear the map to mark all files as unchanged
        }
    }

    public void add(String filename) {
        if (fileSnapshots.containsKey(filename)) {
            System.out.println("File with the same name already exists.");
        } else {
            addFile(filename);
            changedFiles.put(filename, fileSnapshots.get(filename)); // Add to changedFiles
            System.out.println("File added: " + filename);
        }
    }

    public void info(String filename) {
        if (fileSnapshots.containsKey(filename)) {
            FileSnapshot snapshot = fileSnapshots.get(filename);
            System.out.println("File Name: " + snapshot.getFileName());
            System.out.println("Extension: " + snapshot.getExtension());
            System.out.println("Created Date: " + snapshot.getCreatedDate());
            System.out.println("Updated Date: " + snapshot.getUpdatedDate());

            if (snapshot.getExtension().equalsIgnoreCase("png") || snapshot.getExtension().equalsIgnoreCase("jpg") || snapshot.getExtension().equalsIgnoreCase("svg")) {
                // Print image-specific information
                // Implement this method in the ImageFile class
            } else if (snapshot.getExtension().equalsIgnoreCase("txt")) {
                // Print text-specific information
                // Implement this method in the TextFile class
            } else if (snapshot.getExtension().equalsIgnoreCase("py") || snapshot.getExtension().equalsIgnoreCase("java") || snapshot.getExtension().equalsIgnoreCase("html")) {
                // Print program-specific information
                // Implement this method in the ProgramFile class
            }
        } else {
            System.out.println("File not found.");
        }
    }

    public void status() {
        if (snapshotTime == null) {
            System.out.println("No commit has been made yet.");
            return;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Snapshot Time: " + dateFormat.format(snapshotTime));
        System.out.println("File Status:");

        for (FileSnapshot snapshot : fileSnapshots.values()) {
            boolean changed = changedFiles.containsKey(snapshot.getFileName());
            System.out.println(snapshot.getFileName() + " - " + (changed ? "Changed" : "Unchanged"));
        }
    }

    public void addToChangedFiles(String filename) {
        if (fileSnapshots.containsKey(filename)) {
            changedFiles.put(filename, fileSnapshots.get(filename));
        }
    }

    public static void main(String[] args) {
        FileMonitorApp app = new FileMonitorApp();

        // You can add sample files to the system like this:
        app.fileSnapshots.put("example.txt", new FileSnapshot("files/example.txt"));
        app.fileSnapshots.put("logo_ro.svg", new FileSnapshot("files/logo_ro.svg"));
        app.fileSnapshots.put("design.html", new FileSnapshot("files/design.html"));

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("Enter a command (commit, add <filename>, info <filename>, status, exit): ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String command = parts[0].trim();

            switch (command) {
                case "add":
                    if (parts.length > 1) {
                        app.addToChangedFiles(parts[1]);
                        System.out.println("File added: " + parts[1]);
                    } else {
                        System.out.println("Invalid command. Usage: add <filename>");
                    }
                    break;

                case "add file":
                    if (parts.length > 1) {
                        app.addFile(parts[1]);
                    } else {
                        System.out.println("Invalid add command. Usage: add file <filename>");
                    }
                    break;
                case "commit":
                    app.commit();
                    System.out.println("Snapshot time updated.");
                    break;

                case "info":
                    if (parts.length > 1) {
                        app.info(parts[1]);
                    } else {
                        System.out.println("Invalid info command. Usage: info <filename>");
                    }
                    break;

                case "status":
                    app.status();
                    break;

                case "exit":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid command. Available commands: commit, info, status, exit");
                    break;
            }
        }

        System.out.println("Exiting the application.");
        scanner.close();
    }
}
