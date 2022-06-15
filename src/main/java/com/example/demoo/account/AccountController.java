package com.example.demoo.account;

import com.example.demoo.dtos.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5000", "http://localhost:8181"})
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
    public List<Account> getAccounts()
    {
        return AccountService.getAccounts();
    }

    @GetMapping(value = "/employees")
    public List<Account> getEmployeeAccounts() throws Exception {
        List<Account> retrievedAccounts = null;
        try
        {
           retrievedAccounts = AccountService.getEmployeeAccounts();
        }
        catch(Exception ex)
        {
            throw new Exception((ex.getMessage()));
        }
        return retrievedAccounts;
    }

    @PostMapping(value = "/create")
    public void createAccount(@RequestBody AccountDto newAccount)
    {
        AccountService.addAccount(newAccount);
    }

    @GetMapping("/{Id}")
    public Optional<Account> getAccountById(@PathVariable int Id)
    {
        return AccountService.selectAccountById(Id);
    }

    @PutMapping("/{Id}")
    public void UpdateAccount(@PathVariable("Id") int id, @RequestBody Account account)
    {
        AccountService.updateAccount(new AccountDto(id, account.getName(), account.getPassword(), account.getDateofbirth(), account.getEmail()));
    }

    @DeleteMapping("/{Id}")
    public void DeleteAccount(@PathVariable("Id") int Id) {
        AccountService.deleteAccount(Id);
    }
}
