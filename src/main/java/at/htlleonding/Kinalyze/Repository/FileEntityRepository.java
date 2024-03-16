package at.htlleonding.Kinalyze.Repository;

import at.htlleonding.Kinalyze.Entity.AnalyzedDataEntity;
import at.htlleonding.Kinalyze.Entity.FileEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FileEntityRepository extends CrudRepository<FileEntity, String> {

    @Query("SELECT f FROM FileEntity f")
    List<FileEntity> findAllEntities();

    @Query("SELECT f FROM FileEntity f WHERE f.user_uid = :uid")
    FileEntity findByUser_Uid(String uid);

    @Query("SELECT f FROM AnalyzedDataEntity f")
    List<AnalyzedDataEntity> findFileEntities();



    @Override
    <S extends FileEntity> S save(S entity);
}
