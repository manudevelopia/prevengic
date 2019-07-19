package info.developia.prevengic.repository;

import info.developia.prevengic.dao.WarningAdvice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WarningAdviceRepository extends JpaRepository<WarningAdvice, Long> {

    Optional<WarningAdvice> findByCode(String code);


}
