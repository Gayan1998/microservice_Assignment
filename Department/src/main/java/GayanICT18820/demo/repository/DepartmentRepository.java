package GayanICT18820.demo.repository;

import GayanICT18820.demo.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
    @Query("SELECT s FROM StudentEntity s WHERE s.firstName LIKE %:name% OR s.lastName LIKE %:name%")
    List<DepartmentEntity> findByName(@Param("name") String name);
}
