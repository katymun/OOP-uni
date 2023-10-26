import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFile extends FileSnapshot {
    private int lineCount;
    private int wordCount;
    private int charCount;

    public TextFile(String filePath) {
        super(filePath);
        extractTextFileInfo(filePath);
    }

    private void extractTextFileInfo(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            List<String> lines = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                lines.add(line);
                charCount += line.length();
            }
            reader.close();
            lineCount = lines.size();
            wordCount = countWords(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int countWords(List<String> lines) {
        int count = 0;
        for (String line : lines) {
            String[] words = line.split("\\s+");
            count += words.length;
        }
        return count;
    }

    public int getLineCount() {
        return lineCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public int getCharCount() {
        return charCount;
    }
}
