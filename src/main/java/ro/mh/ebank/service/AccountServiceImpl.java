package ro.mh.ebank.service;


import org.springframework.stereotype.Service;
import ro.mh.ebank.exception.ResourceNotFoundException;
import ro.mh.ebank.model.Account;
import ro.mh.ebank.repository.AccountRepository;
import ro.mh.ebank.repository.UserRepository;

import java.util.Optional;


@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final UserRepository userRepository;

    public AccountServiceImpl(AccountRepository accountRepository, UserRepository userRepository) {
        super();
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Optional<Account> createAccount(Long userId, Account accountRequest) throws ResourceNotFoundException {
        return userRepository.findById(userId)
                .map(user -> {
                    accountRequest.setUser(user);
                    return accountRepository.save(accountRequest);
                });
    }
}
