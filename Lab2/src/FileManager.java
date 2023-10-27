import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileManager {
    private List<FileSnapshot> snapshots = new ArrayList<>();
    private Date lastCommit;
    private List<String> storedFileNames = new ArrayList<>();

    public void commit() {
        this.lastCommit = new Date();
        System.out.println("Done commit at " + lastCommit.toString());
        for (FileSnapshot snapshot : snapshots) {
            snapshot.updateSnapshot();
        }
    }

    public void addSnapshot(FileSnapshot snapshot) {
        snapshots.add(snapshot);
        storedFileNames.add(snapshot.getName());
    }

    public void printStatus() {
        for (FileSnapshot snapshot : snapshots) {
            if (snapshot.hasChanged()) {
                System.out.println(snapshot.getName() + " - Changed");
            } else {
                System.out.println(snapshot.getName() + " - No Change");
            }
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
