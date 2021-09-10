package ro.mh.ebank.service;


import org.springframework.data.domain.Page;
import ro.mh.ebank.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    List<Account> getAllAccount();

    Optional<Account> createAccount(Long userId, Account accountRequest);

    Account getAccountById(Long id);

    List<Account> getAccountByUserId(Long userId);

    void deleteAccount(Long accountId);

    Account updateAccount(long id, Account account);
}
