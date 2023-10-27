import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileSnapshot {
    private String name;
    private String extension;
    private Date lastModified;
    private Date created;
    private long size;

    public FileSnapshot(String name) {
        this.name = name;
        this.extension = name.split(".")[-1];
        this.lastModified = new Date();
        this.created = new Date();
        File file = new File(name);
        this.size = file.length();
    }

    public String getName() {
        return name;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public Date getCreated() {
        return created;
    }

    public long getSize() {
        return size;
    }
    public String getExtension() {
        return extension;
    }

    public void updateSnapshot() {
        this.lastModified = new Date();
        File file = new File(name);
        this.size = file.length();
    }

    public void printInfo() {
        System.out.println("File: " + name);
        System.out.println("Extensions: " + extension);
        System.out.println("Size: " + size + " bytes");
        System.out.println("Last Modified: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lastModified));
    }

    public boolean hasChanged() {
        File file = new File(name);
        return file.length() != size || file.lastModified() != lastModified.getTime();
    }
}
