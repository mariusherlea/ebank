package ro.mh.ebank.service;


import org.springframework.stereotype.Service;
import ro.mh.ebank.exception.ResourceNotFoundException;
import ro.mh.ebank.model.Account;
import ro.mh.ebank.repository.AccountRepository;
import ro.mh.ebank.repository.UserRepository;

import java.util.List;
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
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> createAccount(Long userId, Account accountRequest) throws ResourceNotFoundException {
        return userRepository.findById(userId)
                .map(user -> {
                    accountRequest.setUser(user);
                    return accountRepository.save(accountRequest);
                });
    }



    @Override
    public Account getAccountById(Long id) throws ResourceNotFoundException{
        Optional<Account> result = accountRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new ResourceNotFoundException(id);
        }
    }

    @Override
    public List<Account> getAccountByUserId(Long userId) throws ResourceNotFoundException{
        return accountRepository.findByUserId(userId);
    }

    @Override
    public void deleteAccount(Long accountId) throws ResourceNotFoundException{
        accountRepository.delete(getAccountById(accountId));
    }

    @Override
    public Account updateAccount(long id, Account account) {
        Account account1 = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        account1.setAccountNumber(account.getAccountNumber());
        account1.setBank(account.getBank());
        account1.setAmount(account.getAmount());

        return accountRepository.save(account1);
    }
}
