package com.example.demoo.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "api/v1/account")
public class AccountController
{
    private final AccountService AccountService;

    @Autowired
    public AccountController(AccountService accountService)
    {
       this.AccountService = accountService;
    }
    @GetMapping
    public List<Account> GetAccounts()
    {
        return AccountService.GetAccounts();
    }

    @PostMapping(value = "/create")
    public Account CreateAccount(@RequestBody Account newAccount)
    {
        return AccountService.AddAccount(newAccount);
    }
}
