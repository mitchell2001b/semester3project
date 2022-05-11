package com.example.demoo.repositories;

import com.example.demoo.account.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class IAccountRepositoryTest {

    @Autowired
    private IAccountRepository underTestAccountRepo;

    @Test
    void selectAllEmployees() {

        //arrange
        Account account1 = new Account("name1", "accountpassword1", LocalDate.from(LocalDateTime.now()), 0, "email1");
        Account employee1 = new Account("namee1", "accountpassword1", LocalDate.from(LocalDateTime.now()), 1, "email12");
        Account account2 = new Account("name2", "accountpassword1", LocalDate.from(LocalDateTime.now()), 0, "email13");

        underTestAccountRepo.save(account1);
        underTestAccountRepo.save(account2);
        underTestAccountRepo.save(employee1);

        //act
        List<Account> expected = underTestAccountRepo.selectAllEmployees();

        //assert
        assertThat(expected.stream().count()).isEqualTo(1);
    }
}