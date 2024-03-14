package at.htlleonding.Kinalyze.Repository;

import at.htlleonding.Kinalyze.Entity.FileEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FileEntityRepository extends CrudRepository<FileEntity, String> {

    @Query("SELECT f FROM FileEntity f")
    List<FileEntity> findAllEntities();

    @Override
    <S extends FileEntity> S save(S entity);
}
