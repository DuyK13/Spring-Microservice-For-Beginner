package c99.ams.oauthservice.repository;

import c99.ams.oauthservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 6/22/2021 4:14 PM
 */
@Repository
public interface UserDetailsRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
