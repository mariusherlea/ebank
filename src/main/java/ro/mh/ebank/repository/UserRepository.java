package ro.mh.ebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mh.ebank.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
