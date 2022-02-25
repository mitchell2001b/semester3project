package com.example.demoo.account;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService
{
    public List<Account> GetAccounts()
    {
        Account user = new Account(1L, "pip", LocalDate.now(), "test", "test@gmail.com");
        List<Account> users = new ArrayList<Account>();
        System.out.println("test hoi hoi hoi hoi");
        users.add(user);

        return users;

    }
}
