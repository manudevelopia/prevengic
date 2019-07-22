package info.developia.prevengic.repository;

import info.developia.prevengic.dao.ReportDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<ReportDao, String> {

}
