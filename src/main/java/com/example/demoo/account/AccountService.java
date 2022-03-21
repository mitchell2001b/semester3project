package com.example.demoo.account;

import com.example.demoo.Dal.AccountDal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AccountService
{

    private AccountDal Dal;

    @Autowired
    public AccountService(AccountDal dal) {
        this.Dal = dal;
    }

    public List<Account> GetAccounts()
    {
        Account user = new Account(null, "pip", LocalDate.now(), "test", "test@gmail.com");
        //repo.save(user);
        List<Account> users = Dal.GetAllAccountsFromDal();
        Account t = users.get(0);
        System.out.println("test hoi hoi hoi hoi");
        //users.add(user);
        //new ArrayList<Account>();


        return users;

    }

    public Account AddAccount(Account newAccount)
    {
        Dal.AddAccountToDatabase(newAccount);
        System.out.println(newAccount.getDateOfBirth());
        System.out.println(newAccount.getEmail());
        return newAccount;
    }
}
