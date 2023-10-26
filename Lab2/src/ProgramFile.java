public class ProgramFile extends FileSnapshot {
    private int lineCount;
    private int classCount;
    private int methodCount;

    public ProgramFile(String filePath) {
        super(filePath);
        extractProgramFileInfo(filePath);
    }

    private void extractProgramFileInfo(String filePath) {
        // Implement the logic to count lines, classes, and methods in program files
        // You can reuse the code from the previous laboratory if available
    }

    public int getLineCount() {
        return lineCount;
    }

    public int getClassCount() {
        return classCount;
    }

    public int getMethodCount() {
        return methodCount;
    }
}