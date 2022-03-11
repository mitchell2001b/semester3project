package com.example.demoo.Dal;

import com.example.demoo.account.Account;
import com.example.demoo.repositories.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountDal
{
    private IAccountRepository repo;

    @Autowired
    public AccountDal(IAccountRepository repo) {
        this.repo = repo;
    }

    public List<Account> GetAllAccountsFromDal()
    {
        return repo.findAll();
    }
}
