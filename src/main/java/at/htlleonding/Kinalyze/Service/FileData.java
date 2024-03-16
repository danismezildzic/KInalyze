package at.htlleonding.Kinalyze.Service;

import at.htlleonding.Kinalyze.Entity.AnalyzedDataEntity;
import at.htlleonding.Kinalyze.Entity.FileEntity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

import java.io.File;

public class FileData {
        private String user_id;
        private String file_name;
        private String file_type;
        private Long file_size;
        private String file_content;
        private FileEntity analyzedData;
        public FileEntity getAalyzedCode() {
            return analyzedData;
        }
        public FileData(String user_id, String file_name, String file_type, Long file_size, String file_content){
            this.user_id = user_id;
            this.file_name = file_name;
            this.file_type = file_type;
            this.file_size = file_size;
            this.file_content = file_content;
            analyzedData = analyzedData(file_content);
        }
        public FileEntity analyzedData(String code){
            int data_type = 0; //Funktion not implemented yet
            String constructs = ""; //Funktion not implemented yet
            String unreadables = ""; //Funktion not implemented yet
            return new FileEntity(user_id, file_name, file_type, file_size, file_content, LangDetection.LangDetect(file_content));
        }
    }
