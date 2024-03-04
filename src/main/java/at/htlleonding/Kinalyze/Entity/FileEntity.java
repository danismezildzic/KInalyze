package at.htlleonding.Kinalyze.Entity;

import jakarta.persistence.*;

@Entity
public class FileEntity {
    @Id
    private String id;

    private String fileName;

    private String contentType;

    private Long fileSize;

    @Lob
    private byte[] fileContent;

    public FileEntity() {
    }

    public FileEntity(String fileName, String contentType, Long fileSize, byte[] fileContent) {
        this.fileName = fileName;
        this.contentType = contentType;
        this.fileSize = fileSize;
        this.fileContent = fileContent;
    }

    public String getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public byte[] getFileContent() {
        return fileContent;
    }
}
