package info.developia.prevengic.repository;

import info.developia.prevengic.dao.Compound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompoundRepository extends JpaRepository<Compound, String> {

    Optional<Compound> findByName(String name);

}
