package ro.mh.ebank.service;


import ro.mh.ebank.model.Account;
import ro.mh.ebank.model.User;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    List<Account> getAllAccount();

    Optional<Account> createAccount(Long userId, Account accountRequest);

    Account getAccountById(Long id);
}
