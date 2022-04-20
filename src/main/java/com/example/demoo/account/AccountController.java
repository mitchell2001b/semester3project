package com.example.demoo.account;

import com.example.demoo.dtos.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        System.out.println("Howdy3");
        return AccountService.GetAccounts();
    }

    @GetMapping(value = "/employees")
    public List<Account> GetEmployeeAccounts() throws Exception {
        List<Account> retrievedAccounts = null;
        try
        {
           retrievedAccounts = AccountService.GetEmployeeAccounts();
        }
        catch(Exception ex)
        {
            throw new Exception((ex.getMessage()));
        }
        return retrievedAccounts;
    }

    @PostMapping(value = "/create")
    public void CreateAccount(@RequestBody AccountDto newAccount)
    {
        System.out.println(newAccount);
        System.out.println(newAccount.getEmail());
        AccountService.AddAccount(newAccount);
    }

    @GetMapping("/{Id}")
    public Optional<Account> GetAccountById(@PathVariable int Id)
    {
        System.out.println(Id + "joo");
        return AccountService.SelectAccountById(Id);
    }

    @PutMapping("/{Id}")
    public void UpdateAccount(@PathVariable("Id") int id, @RequestBody Account account)
    {
        AccountService.UpdateAccount(new AccountDto(id, account.getName(), account.getPassword(), account.getDateofbirth(), account.getEmail()));
    }

    @DeleteMapping("/{Id}")
    public void DeleteAccount(@PathVariable("Id") int Id) {
        AccountService.DeleteAccount(Id);
    }
}
