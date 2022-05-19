package com.example.demoo.task;

import com.example.demoo.account.Account;
import com.example.demoo.dtos.AccountDto;
import com.example.demoo.dtos.TaskDto;
import com.example.demoo.repositories.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TaskService
{
    private ITaskRepository repo;

    @Autowired
    public TaskService(ITaskRepository repo) {
        this.repo = repo;
    }

    public List<TaskDto> GetTasks()
    {
        List<TaskDto> dtos = new ArrayList<TaskDto>();
        for (Task task : repo.findAll())
        {
            AccountDto newAccountDto = new AccountDto();
            newAccountDto.setAccountid(task.getAccount().getAccountid());
            newAccountDto.setEmail(task.getAccount().getEmail());
            TaskDto newDto = new TaskDto(task.getTaskid(), task.getTitle(), task.getDescription(), task.getCompleted(), task.getCreatedat(), newAccountDto);
            dtos.add(newDto);
        }
        return dtos;
    }

    public List<TaskDto> GetTasksFromAccount(AccountDto account)
    {
        System.out.println("harja");
        List<TaskDto> dtos = new ArrayList<TaskDto>();
        AccountDto newAccountDto = new AccountDto();
        newAccountDto.setAccountid(account.getAccountid());
        newAccountDto.setEmail(account.getEmail());
        for (Task task : this.repo.findTasksByAccountId(account.getAccountid()))
        {
            TaskDto newDto = new TaskDto(task.getTaskid(), task.getTitle(), task.getDescription(), task.getCompleted(), task.getCreatedat(), newAccountDto);
            dtos.add(newDto);
        }
        return dtos;
    }

    public Task AddTask(TaskDto newTask)
    {
        newTask.setCompleted(false);
        newTask.setCreatedat(LocalDate.now());
        System.out.println(newTask);
        Task taskToAdd = new Task(newTask.getTitle(), newTask.getDescription(), newTask.getCompleted(), newTask.getCreatedat(), new Account(newTask.getAccount().getAccountid(), null, null, null, 0, null, null));

        this.repo.save(taskToAdd);

        return this.repo.findLastCreatedTask();
    }

    public Optional<Task> SelectTaskById(int id)
    {
        System.out.println(id + "ppppxxxxxl");
        System.out.println(this.repo.existsById(id));

        return this.repo.findById(id);
    }

    @Transactional
    public void UpdateTask(TaskDto dto)
    {
        System.out.println(dto.getTaskid() + "jjjjj");
        Task task = this.repo.findById(dto.getTaskid()).orElseThrow(() -> new IllegalStateException("product with id: " + dto.getTaskid() + " not found!"));

        if(dto.getCompleted() != null && !Objects.equals(dto.getCompleted(), task.getCompleted()))
        {
            task.setCompleted(dto.getCompleted());
        }
        if(dto.getTitle() != null && !Objects.equals(dto.getTitle(), task.getTitle()))
        {
            task.setTitle(dto.getTitle());
        }
        if(dto.getDescription() != null && !Objects.equals(dto.getDescription(), task.getDescription()))
        {
            task.setDescription(dto.getDescription());
        }

        if(dto.getAccount() != null)
        {
            if(dto.getAccount().getAccountid() != 0 && task.getAccount().getAccountid() != dto.getAccount().getAccountid())
            {
                task.setAccount(new Account(dto.getAccount().getAccountid(), null, null, null, 0, null));
            }
        }
    }

    public void DeleteTask(int id)
    {
        Optional<Task> taskToDelete = repo.findById(id);
        if(repo.existsById(id))
        {
            this.repo.deleteById(id);
        }
    }
}
