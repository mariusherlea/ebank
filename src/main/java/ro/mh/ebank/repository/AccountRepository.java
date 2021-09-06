package ro.mh.ebank.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ro.mh.ebank.model.Account;

import java.util.List;


public interface AccountRepository extends JpaRepository<Account, Long> {

  List<Account> findByUserId(Long postId);

}
