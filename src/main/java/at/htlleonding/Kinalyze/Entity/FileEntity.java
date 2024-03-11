package at.htlleonding.Kinalyze.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "KIN_DB")
public class FileEntity {
    @Id
    private String user_uid;

    private String file_name;

    private String file_type;

    private Long file_size;

    @Lob
    private byte[] file_content;

    private String file_lang;

    private int var_eng;

    private boolean indents;

    private int complex;

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

    public FileEntity() {
    }

    public FileEntity(String user_uid, String fileName, String fileType, Long fileSize, byte[] fileContent, String fileLang,
                      int varEng, boolean indents, int complex, int dataType, int badInits,
                      String badPracs, String comments, String constructs, String unreadables,
                      String namingConvs, String performance) {
        this.user_uid = user_uid;
        this.file_name = fileName;
        this.file_type = fileType;
        this.file_size = fileSize;
        this.file_content = fileContent;
        this.file_lang = fileLang;
        this.var_eng = varEng;
        this.indents = indents;
        this.complex = complex;
        this.data_type = dataType;
        this.bad_inits = badInits;
        this.bad_pracs = badPracs;
        this.comments = comments;
        this.constructs = constructs;
        this.unreadables = unreadables;
        this.naming_convs = namingConvs;
        this.performance = performance;
    }
}

