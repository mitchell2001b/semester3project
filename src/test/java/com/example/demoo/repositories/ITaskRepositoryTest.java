package com.example.demoo.repositories;
import com.example.demoo.task.Task;
import com.example.demoo.account.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class ITaskRepositoryTest {

    @Autowired
    private ITaskRepository underTestTaskRepo;

    @Autowired
    private IAccountRepository underTestAccountRepo;

    @Test
    void CheckIfAccountWith2TasksReturnsATotalOf2Tasks() {

        //arrange
        Account account1 = new Account("name1", "accountpassword1", LocalDate.from(LocalDateTime.now()), 0, "email1");
        underTestAccountRepo.save(account1);
        List<Account> savedTestAccounts = underTestAccountRepo.findAll();

        Task task1 = new Task("title1", "description1", false, LocalDate.from(LocalDateTime.now()), savedTestAccounts.get(0));
        Task task2 = new Task("title2", "description2", false, LocalDate.from(LocalDateTime.now()), savedTestAccounts.get(0));

        underTestTaskRepo.save(task1);
        underTestTaskRepo.save(task2);

        //act
        List<Task> expectedACountOf2Tasks = underTestTaskRepo.findTasksByAccountId(savedTestAccounts.get(0).getAccountid());


        //assert
        assertThat(expectedACountOf2Tasks.stream().count()).isEqualTo(2);

    }

    @Test
    void CheckIflastCreatedTaskIsReturned()
    {
        //arrange
        Account account1 = new Account("name1", "accountpassword1", LocalDate.from(LocalDateTime.now()), 0, "email1");
        underTestAccountRepo.save(account1);
        List<Account> savedTestAccounts = underTestAccountRepo.findAll();

        Task task1 = new Task("title1", "description1", false, LocalDate.from(LocalDateTime.now()), savedTestAccounts.get(0));
        Task task2 = new Task("title2", "description2", false, LocalDate.from(LocalDateTime.now()), savedTestAccounts.get(0));

        underTestTaskRepo.save(task1);
        underTestTaskRepo.save(task2);

        //act
        Task expected = underTestTaskRepo.findLastCreatedTask();

        //assert
        assertThat(expected.getDescription()).isEqualTo("description2");
        assertThat(expected.getTitle()).isEqualTo("title2");
        assertThat(expected).isEqualTo(task2);
    }

}