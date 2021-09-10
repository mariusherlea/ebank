package ro.mh.ebank.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import ro.mh.ebank.dto.AccountDto;
import ro.mh.ebank.model.Account;
import ro.mh.ebank.service.AccountService;
import ro.mh.ebank.service.UserService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private ModelMapper modelMapper;

    private AccountService accountService;

    private UserService userService;

    public AccountController(AccountService accountService) {
        super();
        this.accountService = accountService;
    }

    @GetMapping
    public List<AccountDto> getAllAccount() {

        return accountService.getAllAccount().stream().map(account -> modelMapper.map(account, AccountDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAccountById(@PathVariable(name = "id") Long id) {

        Account account = accountService.getAccountById(id);

        AccountDto accountResponse = modelMapper.map(account, AccountDto.class);

        return ResponseEntity.ok().body(accountResponse);

    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<Object> getAccountByUserId(@PathVariable(name = "userId") Long userId) {

        List<Account> account = accountService.getAccountByUserId(userId);

        List<AccountDto> userDtoList = mapList(account, AccountDto.class);

        return ResponseEntity.ok(userDtoList);

    }



    @PostMapping("/users/{userId}/accounts")

    public Account createAccount(@PathVariable(value = "userId") Long userId, @RequestBody AccountDto accountDto) {

        Account accountRequest = modelMapper.map(accountDto, Account.class);

        Optional<Account> account = accountService.createAccount(userId, accountRequest);

        AccountDto accountResponse = modelMapper.map(account, AccountDto.class);

        return null;
    }

    @PutMapping("/update/{id}")
    public Account updateAccount(@PathVariable long id, @RequestBody AccountDto accountDto) {

        Account account = modelMapper.map(accountDto, Account.class);
        account = accountService.updateAccount(id, account);
        return account;

    }

    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable(name = "id") Long id) {
        accountService.deleteAccount(id);
        return "Account with " + id + "was successfully deleted";
    }

    <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
}
