package info.developia.prevengic.repository;

import info.developia.prevengic.dao.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Long> {

    Optional<Note> findByCode(String code);

}
