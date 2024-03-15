package at.htlleonding.Kinalyze.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "KIN_DB")
public class FileEntity {
    @Id
    private String user_uid;

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

    public void setVar_eng(int var_eng) {
        this.var_eng = var_eng;
    }

    public void setIndents(boolean indents) {
        this.indents = indents;
    }

    public void setComplex(String complex) {
        this.complex = complex;
    }

    public void setData_type(int data_type) {
        this.data_type = data_type;
    }

    public void setBad_inits(int bad_inits) {
        this.bad_inits = bad_inits;
    }

    public void setBad_pracs(String bad_pracs) {
        this.bad_pracs = bad_pracs;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setConstructs(String constructs) {
        this.constructs = constructs;
    }

    public void setUnreadables(String unreadables) {
        this.unreadables = unreadables;
    }

    public void setNaming_convs(String naming_convs) {
        this.naming_convs = naming_convs;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
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

    public int getVar_eng() {
        return var_eng;
    }

    public boolean isIndents() {
        return indents;
    }

    public String getComplex() {
        return complex;
    }

    public int getData_type() {
        return data_type;
    }

    public int getBad_inits() {
        return bad_inits;
    }

    public String getBad_pracs() {
        return bad_pracs;
    }

    public String getComments() {
        return comments;
    }

    public String getConstructs() {
        return constructs;
    }

    public String getUnreadables() {
        return unreadables;
    }

    public String getNaming_convs() {
        return naming_convs;
    }

    public String getPerformance() {
        return performance;
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

    public FileEntity() {
    }

    public FileEntity(String user_uid, String fileName, String fileType, Long fileSize, String fileContent, String fileLang,
                      int varEng, boolean indents, String complex, int dataType, int badInits,
                      String badPracs, String comments, String constructs, String unreadables,
                      String namingConvs, String performance, double lineMethodRatio) {
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
                ", var_eng=" + var_eng +
                ", indents=" + indents +
                ", complex=" + complex +
                ", data_type=" + data_type +
                ", bad_inits=" + bad_inits +
                ", bad_pracs='" + bad_pracs + '\'' +
                ", comments='" + comments + '\'' +
                ", constructs='" + constructs + '\'' +
                ", unreadables='" + unreadables + '\'' +
                ", naming_convs='" + naming_convs + '\'' +
                ", performance='" + performance + '\'' +
               // ", lineRatio='" + lineMethodRatio + '\'' +
                '}';
    }
}

