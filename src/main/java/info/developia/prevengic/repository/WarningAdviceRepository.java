package info.developia.prevengic.repository;

import info.developia.prevengic.dao.WarningAdviceDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WarningAdviceRepository extends JpaRepository<WarningAdviceDao, Long> {

    Optional<WarningAdviceDao> findByCode(String code);


}
