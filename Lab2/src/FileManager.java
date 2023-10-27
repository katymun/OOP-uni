import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.nio.file.*;

public class FileManager {
    private List<FileSnapshot> snapshots;
    private Date lastCommit;
    private List<String> storedFileNames;
    Path folderPath;

    public FileManager(Path folderPath) {
        snapshots = new ArrayList<>();
        storedFileNames = new ArrayList<>();
        this.folderPath = folderPath;
    }

    public Date getLastCommit() {
        return lastCommit;
    }

    public Path getFolderPath() {
        return folderPath;
    }

    public void commit() {
        this.lastCommit = new Date();
        System.out.println("Done commit at " + lastCommit.toString());
        for (FileSnapshot snapshot : snapshots) {
            snapshot.updateSnapshot();
        }
    }

    public void addSnapshot(String name) {
        FileSnapshot snapshot = null;
        String extension = name.split(".")[-1];
        switch (extension) {
            case "png": snapshot = new ImageFileSnapshot(name); break;
            case "jpg": snapshot = new ImageFileSnapshot(name); break;
            case "txt": snapshot = new TextFileSnapshot(name); break;
            case "py": snapshot = new ProgramFileSnapshot(name); break;
            case "java": snapshot = new ProgramFileSnapshot(name); break;
            default: snapshot = new FileSnapshot(name);
        }

        snapshots.add(snapshot);
        storedFileNames.add(name);
    }

    public void printStatus() {
        for (FileSnapshot snapshot : snapshots) {
            if (snapshot.hasChanged()) {
                System.out.println(snapshot.getName() + " - Changed");
            } else {
                System.out.println(snapshot.getName() + " - No Change");
            }
        }
        try {

            WatchService watchService = FileSystems.getDefault().newWatchService();

            folderPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE);

            WatchKey key = watchService.poll();
            if (key != null) {
                for (WatchEvent<?> event : key.pollEvents()) {
                    if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                        String name = (String) event.context();
                        FileSnapshot snapshot = null;
                        String extension = name.split(".")[-1];
                        switch (extension) {
                            case "png": snapshot = new ImageFileSnapshot(name); break;
                            case "jpg": snapshot = new ImageFileSnapshot(name); break;
                            case "txt": snapshot = new TextFileSnapshot(name); break;
                            case "py": snapshot = new ProgramFileSnapshot(name); break;
                            case "java": snapshot = new ProgramFileSnapshot(name); break;
                            default: snapshot = new FileSnapshot(name);
                        }

                        snapshots.add(snapshot);
                        storedFileNames.add(name);
                    } else if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
                        String name = (String) event.context();
                        FileSnapshot snapshot = null;
                        String extension = name.split(".")[-1];
                        switch (extension) {
                            case "png": snapshot = new ImageFileSnapshot(name); break;
                            case "jpg": snapshot = new ImageFileSnapshot(name); break;
                            case "txt": snapshot = new TextFileSnapshot(name); break;
                            case "py": snapshot = new ProgramFileSnapshot(name); break;
                            case "java": snapshot = new ProgramFileSnapshot(name); break;
                            default: snapshot = new FileSnapshot(name);
                        }

                        snapshots.add(snapshot);
                        storedFileNames.add(name);
                    }
                }
                key.reset();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteFile(String filename) {
        int index = storedFileNames.indexOf(filename);
        if (index != -1) {
            snapshots.remove(index);
            storedFileNames.remove(index);
        }
    }

    public void printAllFilesInfo() {
        System.out.println("Total files: " + snapshots.size());
        for (FileSnapshot snapshot : snapshots) {
            snapshot.printInfo();
        }
    }
}
