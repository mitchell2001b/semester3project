package com.example.demoo.account;

import com.example.demoo.dtos.AccountDto;
import com.example.demoo.repositories.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AccountService
{

    //private AccountDal Dal;
    private IAccountRepository repo;

    @Autowired
    public AccountService(IAccountRepository repo) {
        this.repo = repo;
    }

    public List<Account> getAccounts()
    {
        return repo.findAll();
    }

    public List<Account> getEmployeeAccounts() throws Exception {

        List<Account> retrievedAccounts = null;
        try
        {
            retrievedAccounts = this.repo.selectAllEmployees();
        }
        catch (Exception ex)
        {
            throw  new Exception("Could not select employees");
        }
        return retrievedAccounts;
    }
    public void addAccount(AccountDto newAccount)
    {
        Account accountToAdd = new Account(newAccount.getName(), newAccount.getPassword(), newAccount.getDateofbirth(), 1, newAccount.getEmail(), null);
        this.repo.save(accountToAdd);
    }

    public Optional<Account> selectAccountById(int id)
    {
        return this.repo.findById(id);
    }

    public void deleteAccount(int id)
    {
        Optional<Account> accountToDelete = repo.findById(id);
        if(repo.existsById(id))
        {
            this.repo.deleteById(id);
        }
    }

    @Transactional
    public void updateAccount(AccountDto dto)
    {
        Account account = this.repo.findById(dto.getAccountid()).orElseThrow(() -> new IllegalStateException("product with id: " + dto.getAccountid() + " not found!"));

        if(dto.getName() != null && dto.getName().length() > 0 && !Objects.equals(dto.getName(), account.getName()))
        {
            account.setName(dto.getName());
        }
        if(dto.getEmail() != null && dto.getEmail().length() > 0 && !Objects.equals(dto.getEmail(), account.getEmail()))
        {
            account.setEmail(dto.getEmail());
        }

    }
}
