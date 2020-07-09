package com.drunkdevelopers.microjs.language;

public class FileLocation {
    private final String filePath;
    private final int x;
    private final int y;

    public FileLocation(String filePath, int x, int y) {
        this.filePath = filePath;
        this.x = x;
        this.y = y;
    }

    public String getFilePath() { return filePath; }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}