package com.digitalskills.dvla.model;

public class FileInfo {

    private final String fileName;
    private final String filePath;
    private final String mimeType;
    private final long size;
    private final String extension;

    public FileInfo(String fileName, String filePath, String mimeType, long size, String extension) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.mimeType = mimeType;
        this.size = size;
        this.extension = extension;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getMimeType() {
        return mimeType;
    }

    public long getSize() {
        return size;
    }

    public String getExtension() {
        return extension;
    }

}