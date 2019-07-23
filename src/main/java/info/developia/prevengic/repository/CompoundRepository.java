package info.developia.prevengic.repository;

import info.developia.prevengic.dao.CompoundDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompoundRepository extends JpaRepository<CompoundDao, String> {

    Optional<CompoundDao> findByName(String name);

}
