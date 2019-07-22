package info.developia.prevengic.repository;

import info.developia.prevengic.dao.NoteDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NoteRepository extends JpaRepository<NoteDao, Long> {

    Optional<NoteDao> findByCode(String code);

}
