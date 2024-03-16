package at.htlleonding.Kinalyze.Service;

import at.htlleonding.Kinalyze.Entity.AnalyzedDataEntity;
import at.htlleonding.Kinalyze.Entity.FileEntity;
import at.htlleonding.Kinalyze.Repository.FileEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FileService {

    private final FileEntityRepository fileEntityRepository;

    public FileService(FileEntityRepository fileEntityRepository) {
        this.fileEntityRepository = fileEntityRepository;
    }

    public List<FileEntity> getAllFiles() {
        return fileEntityRepository.findAllEntities();
    }

    public FileEntity getFileByUID(String uid) {
        return fileEntityRepository.findByUser_Uid(uid);
    }

    public List<AnalyzedDataEntity> getAllAnalyzedData(){
        return fileEntityRepository.findFileEntities();
    }

    public void saveFileEntity(FileEntity fileEntity) {
        fileEntityRepository.save(fileEntity);
    }

}
