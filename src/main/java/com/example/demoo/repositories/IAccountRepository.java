package com.example.demoo.repositories;

import com.example.demoo.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAccountRepository extends JpaRepository<Account, Integer>
{
    @Query(value = "SELECT * FROM account where role = 1", nativeQuery = true)
    public List<Account> selectAllEmployees();
}
