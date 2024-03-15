package at.htlleonding.Kinalyze.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "FILE_ATTRIBUTES")
public class FileEntity {
    @Id
    private String user_uid;

    public FileEntity() {

    }

    public String getUser_uid() {
        return user_uid;
    }

    public void setUser_uid(String user_uid) {
        this.user_uid = user_uid;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public void setFile_size(Long file_size) {
        this.file_size = file_size;
    }

    public void setFile_content(String file_content) {
        this.file_content = file_content;
    }

    public void setFile_lang(String file_lang) {
        this.file_lang = file_lang;
    }

    public String getFile_name() {
        return file_name;
    }

    public String getFile_type() {
        return file_type;
    }

    public Long getFile_size() {
        return file_size;
    }

    public String getFile_content() {
        return file_content;
    }

    public String getFile_lang() {
        return file_lang;
    }

    private String file_name;

    private String file_type;

    private Long file_size;

    @Lob
    private String file_content;

    private String file_lang;

    private int var_eng;

    private boolean indents;

    private String complex;

    private int data_type;

    private int bad_inits;

    @Lob
    private String bad_pracs;

    @Lob
    private String comments;

    @Lob
    private String constructs;

    @Lob
    private String unreadables;

    @Lob
    private String naming_convs;

    private String performance;
   /// private double lineMethodRatio;


    public FileEntity(String user_uid, String fileName, String fileType, Long fileSize, String fileContent, String fileLang){
        this.user_uid = user_uid;
        this.file_name = fileName;
        this.file_type = fileType;
        this.file_size = fileSize;
        this.file_content = fileContent;
        this.file_lang = fileLang;
       // this.lineMethodRatio = lineMethodRatio;
    }

    @Override
    public String toString() {
        return "FileEntity{" +
                "user_uid='" + user_uid + '\'' +
                ", file_name='" + file_name + '\'' +
                ", file_type='" + file_type + '\'' +
                ", file_size=" + file_size +
                ", file_content='" + file_content + '\'' +
                ", file_lang='" + file_lang + '\'' +
                '}';
    }
}

