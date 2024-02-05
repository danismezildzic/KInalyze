package at.htlleonding.Kinalyze.Model;

public class File {
    private String uid;
    private String fileName;
    public File(String uid, String fileName){
        this.uid = uid;
        this.fileName = fileName;
    }

    public String getUid() {
        return uid;
    }

    public String getFileName() {
        return fileName;
    }
}
