package at.htlleonding.Kinalyze.Service;

import at.htlleonding.Kinalyze.Entity.FileEntity;
import at.htlleonding.Kinalyze.Repository.FileEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    private final FileEntityRepository fileEntityRepository;

    @Autowired
    public FileService(FileEntityRepository fileEntityRepository) {
        this.fileEntityRepository = fileEntityRepository;
    }

    public List<FileEntity> getAll() {
        return fileEntityRepository.findAll();
    }

}
