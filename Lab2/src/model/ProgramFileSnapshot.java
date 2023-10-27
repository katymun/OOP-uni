package model;

import model.FileSnapshot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ProgramFileSnapshot extends FileSnapshot {
    private int lineCount;
    private int classCount;
    private int methodCount;

    public ProgramFileSnapshot(String name, String path) {
        super(name, path);
        int classes = 0;
        int lines = 0;
        int methods = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(getFolderPath()+name));
            String line;
            boolean insideClass = false;
            boolean insideMethod = false;

            while ((line = reader.readLine()) != null) {
                lines++;
                if (line.trim().matches(".*\\bclass\\s+\\w+.*")) {
                    classes++;
                    insideClass = true;
                    insideMethod = false;
                }
                if (line.trim().matches(".*\\b\\w+\\s+\\w+\\(.*\\)\\s*\\{.*")) {
                    if (!insideMethod) {
                        methods++;
                        insideMethod = true;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.lineCount = lines;
        this.classCount = classes;
        this.methodCount = methods;
    }

    @Override
    public void updateSnapshot() {
        super.updateSnapshot();
        int classes = 0;
        int lines = 0;
        int methods = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(getFolderPath()+getName()));
            String line;
            boolean insideClass = false;
            boolean insideMethod = false;

            while ((line = reader.readLine()) != null) {
                lines++;
                if (line.trim().matches(".*\\bclass\\s+\\w+.*")) {
                    classes++;
                    insideClass = true;
                    insideMethod = false;
                }
                if (line.trim().matches(".*\\b\\w+\\s+\\w+\\(.*\\)\\s*\\{.*")) {
                    if (!insideMethod) {
                        methods++;
                        insideMethod = true;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.lineCount = lines;
        this.classCount = classes;
        this.methodCount = methods;
    }

    public List<Integer> getCurrectCounts() {
        List<Integer> list = new ArrayList<>();
        int classes = 0;
        int lines = 0;
        int methods = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(getFolderPath()+this.getName()));
            String line;
            boolean insideClass = false;
            boolean insideMethod = false;

            while ((line = reader.readLine()) != null) {
                lines++;
                if (line.trim().matches(".*\\bclass\\s+\\w+.*")) {
                    classes++;
                    insideClass = true;
                    insideMethod = false;
                }
                if (line.trim().matches(".*\\b\\w+\\s+\\w+\\(.*\\)\\s*\\{.*")) {
                    if (!insideMethod) {
                        methods++;
                        insideMethod = true;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        list.add(lines);
        list.add(methods);
        list.add(classes);
        return list;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Line Count: " + lineCount);
        System.out.println("Class Count: " + classCount);
        System.out.println("Method Count: " + methodCount);
    }
}
