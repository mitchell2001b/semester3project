package com.example.demoo.repositories;

import com.example.demoo.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Integer>
{

}
