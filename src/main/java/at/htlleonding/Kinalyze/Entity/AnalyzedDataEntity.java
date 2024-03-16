package at.htlleonding.Kinalyze.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "ANALYZED_DATA")
public class AnalyzedDataEntity {
    @Id
    private String user_uid;

    @Id
    private String file_name;

    private int VAR_ENG;

    private String indents;

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

    public AnalyzedDataEntity(String user_uid, String fileName,
                      int varEng, String indents, String complex, int dataType, int badInits,
                      String badPracs, String comments, String constructs, String unreadables,
                      String namingConvs, String performance, double lineMethodRatio) {
        this.user_uid = user_uid;
        this.file_name = fileName;
        this.VAR_ENG = varEng;
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
    public AnalyzedDataEntity() {

    }

    @Override
    public String toString() {
        return "FileEntity{" +
                "user_uid='" + user_uid + '\'' +
                ", file_name='" + file_name + '\'' +
                ", var_eng=" + VAR_ENG +
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
                '}';
    }

    public String getUser_uid() {
        return user_uid;
    }

    public String getFile_name() {
        return file_name;
    }

    public int getVAR_ENG() {
        return VAR_ENG;
    }

    public String getIndents() {
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
}
