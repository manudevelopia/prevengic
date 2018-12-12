package info.developia.prevengic.repository;

import info.developia.prevengic.dao.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDao, String> {

    Optional<UserDao> findByEmail(String email);

}
