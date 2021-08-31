package ro.mh.ebank.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ro.mh.ebank.dto.AccountDto;
import ro.mh.ebank.model.Account;
import ro.mh.ebank.service.AccountService;
import ro.mh.ebank.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/accounts")
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
    public  ResponseEntity<Object> getAccountById(@PathVariable(name = "id") Long id) {


        Account account = accountService.getAccountById(id);


        // convert entity to DTO
        AccountDto accountResponse = modelMapper.map(account, AccountDto.class);

        return ResponseEntity.ok().body(accountResponse);



    }

    @PostMapping("/users/{userId}/accounts")

    public Account createAccount(@PathVariable(value = "userId") Long userId , @RequestBody AccountDto accountDto) {

        // convert DTO to entity
        Account accountRequest = modelMapper.map(accountDto, Account.class);

        Optional<Account> account = accountService.createAccount(userId, accountRequest);

        // convert entity to DTO
        AccountDto accountResponse = modelMapper.map(account, AccountDto.class);

        return null;
    }


 

}
