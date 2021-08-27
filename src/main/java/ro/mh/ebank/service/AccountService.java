package ro.mh.ebank.service;


import ro.mh.ebank.model.Account;

import java.util.Optional;

public interface AccountService {


    Optional<Account> createAccount(Long userId, Account accountRequest);
}
