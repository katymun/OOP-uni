import model.FileSnapshot;
import model.ImageFileSnapshot;
import model.ProgramFileSnapshot;
import model.TextFileSnapshot;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class FileManager {
    private List<FileSnapshot> snapshots;
    private List<FileSnapshot> snapshotsAdded = new ArrayList<>();
    private List<FileSnapshot> snapshotsDeleted = new ArrayList<>();
    private Date lastCommit;
    private List<String> storedFileNames;
    String folderPath;


    public FileManager(String folderPath) {
        snapshots = new ArrayList<>();
        storedFileNames = new ArrayList<>();
        this.folderPath = folderPath;

    }

    public Date getLastCommit() {
        return lastCommit;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public void commit() {
        for (FileSnapshot snapshot : snapshotsAdded) {
            snapshots.add(snapshot);
            storedFileNames.add(snapshot.getName());
        }
        this.lastCommit = new Date();
        System.out.println("Done commit at " + lastCommit.toString());
        for (FileSnapshot snapshot : snapshots) {
            snapshot.updateSnapshot();
        }
    }

    public void addSnapshot(String name) {
        FileSnapshot snapshot = null;
        int len = name.split("\\.").length;

        String extension = name.split("\\.")[len-1];

        switch (extension) {
            case "png": snapshot = new ImageFileSnapshot(name,folderPath); break;
            case "jpg": snapshot = new ImageFileSnapshot(name,folderPath); break;
            case "txt": snapshot = new TextFileSnapshot(name,folderPath); break;
            case "py": snapshot = new ProgramFileSnapshot(name,folderPath); break;
            case "java": snapshot = new ProgramFileSnapshot(name,folderPath); break;
            default: snapshot = new FileSnapshot(name,folderPath);
        }

        snapshots.add(snapshot);
        storedFileNames.add(name);
    }

    public void printStatus() {

        File folder = new File(folderPath);

        if (folder.isDirectory()) {
            File[] files1 = folder.listFiles();
            List<File> files = Arrays.asList(files1);
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        if (!storedFileNames.contains(file.getName())) {
                            FileSnapshot snapshot = null;
                            String extension = file.getName().split(".")[-1];
                            switch (extension) {
                            case "png": snapshot = new ImageFileSnapshot(file.getName(),folderPath); break;
                            case "jpg": snapshot = new ImageFileSnapshot(file.getName(),folderPath); break;
                            case "txt": snapshot = new TextFileSnapshot(file.getName(),folderPath); break;
                            case "py": snapshot = new ProgramFileSnapshot(file.getName(),folderPath); break;
                            case "java": snapshot = new ProgramFileSnapshot(file.getName(),folderPath); break;
                            default: snapshot = new FileSnapshot(file.getName(),folderPath);
                        }
                            snapshotsAdded.add(snapshot);
                        }
                    }
                }
                for (FileSnapshot snapshot : snapshots) {
                    if (!files.contains(snapshot)) {
                        snapshotsDeleted.add(snapshot);
                    }
                }
                System.out.println(snapshotsDeleted);
                System.out.println(snapshots);
                System.out.println(files);
                for (FileSnapshot snapshot : snapshotsDeleted) {
                    snapshots.remove(snapshot);
                }

                for (FileSnapshot snapshot : snapshots) {
                    if (snapshot.hasChanged()) {
                        System.out.println(snapshot.getName() + " - Changed");
                    } else {
                        System.out.println(snapshot.getName() + " - No Change");
                    }
                }

                for (FileSnapshot snapshot : snapshotsAdded) {
                    System.out.println(snapshot.getName() + " - Created");
                }
                for (FileSnapshot snapshot : snapshotsDeleted) {
                    System.out.println(snapshot.getName() + " - Deleted");
                }
            } else {
                System.out.println("No files found in the folder.");
            }
        } else {
            System.out.println("The specified path is not a directory.");
        }
    }

    public void deleteFile(String filename) {
        int index = storedFileNames.indexOf(filename);
        if (index != -1) {
            snapshots.remove(index);
            storedFileNames.remove(index);
        }
    }

    public void printFileInfo(String name) {
        int index = storedFileNames.indexOf(name);
        FileSnapshot snapshot = snapshots.get(index);
        snapshot.printInfo();
    }

    public void printAllFilesInfo() {
        System.out.println("Total files: " + snapshots.size());
        for (FileSnapshot snapshot : snapshots) {
            snapshot.printInfo();
        }
    }
}
