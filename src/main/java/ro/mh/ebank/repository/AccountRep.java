package ro.mh.ebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mh.ebank.model.Account;


public interface AccountRep extends JpaRepository<Account, Long> {
}
