import java.io.File;
import java.util.Date;

public class FileSnapshot {
    private String fileName;
    private String extension;
    private Date createdDate;
    private Date updatedDate;

    public FileSnapshot(String filePath) {
        File file = new File(filePath);
        fileName = file.getName();
        extension = fileName.substring(fileName.lastIndexOf(".") + 1);
        createdDate = new Date(file.lastModified());
        updatedDate = new Date(file.lastModified());
    }

    public void updateSnapshot(String filePath) {
        File file = new File(filePath);
        updatedDate = new Date(file.lastModified());
    }

    public String getFileName() {
        return fileName;
    }

    public String getExtension() {
        return extension;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }
}
