package ro.mh.ebank.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ro.mh.ebank.dto.AccountDto;
import ro.mh.ebank.dto.UserDto;
import ro.mh.ebank.model.Account;
import ro.mh.ebank.service.AccountService;
import ro.mh.ebank.service.UserService;

import java.util.Optional;


@RestController

public class AccountController {

    @Autowired
    private ModelMapper modelMapper;

    private AccountService accountService;

    private UserService userService;

    public AccountController(AccountService accountService) {
        super();
        this.accountService = accountService;
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
