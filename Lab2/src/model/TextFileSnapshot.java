package model;

import model.FileSnapshot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileSnapshot extends FileSnapshot {
    private int lineCount;
    private int wordCount;
    private int charCount;

    public TextFileSnapshot(String name, String path) {
        super(name, path);
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(getFolderPath()+getName()));
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                lineCount += line.length();
                String[] words = line.split(" ");
                wordCount += words.length;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        this.lineCount = lineCount;
        this.wordCount = wordCount;
        this.charCount = lineCount;
    }

    @Override
    public void updateSnapshot() {
        super.updateSnapshot();
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(getFolderPath()+getName()));
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                String[] words = line.split(" ");
                wordCount += words.length;
                charCount += line.length();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        this.lineCount = lineCount;
        this.wordCount = wordCount;
        this.charCount = lineCount;
    }

    public List<Integer> getCurrectCounts() {
        List<Integer> list = new ArrayList<>();
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(getFolderPath()+getName()));
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                String[] words = line.split(" ");
                wordCount += words.length;
                charCount += line.length();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        list.add(lineCount);
        list.add(wordCount);
        list.add(charCount);
        return list;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Line Count: " + lineCount);
        System.out.println("Word Count: " + wordCount);
        System.out.println("Character Count: " + charCount);
    }
}
