import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ImageFileSnapshot extends FileSnapshot {
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public ImageFileSnapshot(String name, String path) {
        super(name, path);
        try {
            File imageFile = new File(getFolderPath()+getName());
            BufferedImage image = ImageIO.read(imageFile);
            if (image != null) {
                this.width = image.getWidth();
                this.height = image.getHeight();
            } else {
                System.out.println("Failed to read the image!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateSnapshot() {
        super.updateSnapshot();
        try {
            File imageFile = new File(getFolderPath()+getName());
            BufferedImage image = ImageIO.read(imageFile);
            if (image != null) {
                this.width = image.getWidth();
                this.height = image.getHeight();
            } else {
                System.out.println("Failed to read the image!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Integer> getCurrectDimensions() {
        List<Integer> list = new ArrayList<>();
        try {
            File imageFile = new File(getFolderPath()+getName());
            BufferedImage image = ImageIO.read(imageFile);
            if (image != null) {
                list.add(image.getWidth());
                list.add(image.getHeight());
            } else {
                System.out.println("Failed to read the image!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Image Size: " + width + "x" + height);
    }

}
