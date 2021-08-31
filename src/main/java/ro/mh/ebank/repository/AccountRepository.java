package ro.mh.ebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mh.ebank.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

  Account findByUserId(Long postId);

}
