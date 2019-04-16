package info.developia.prevengic.repository;

import info.developia.prevengic.dao.Compound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompoundRepository extends JpaRepository<Compound, String> {

    Optional<List<Compound>> findByNameIgnoreCaseContaining(String name);

    Optional<List<Compound>> findByNceIgnoreCaseContaining(String nce);

    Optional<List<Compound>> findByCasIgnoreCaseContaining(String cas);

    Optional<Compound> findById(Long id);

}
