package at.htlleonding.Kinalyze.Repository;

import at.htlleonding.Kinalyze.Entity.FileEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FileEntityRepository extends CrudRepository<FileEntity, String> {
    @Query("SELECT f FROM FileEntity f WHERE f.id = :id AND f.fileName = :fileName")
    FileEntity findByIdAndFileName(@Param("id") String id, @Param("fileName") String fileName);

    @Query("SELECT f FROM FileEntity f")
    List<FileEntity> getAllFiles();
}
