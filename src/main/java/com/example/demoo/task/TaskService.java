package com.example.demoo.task;

import com.example.demoo.account.Account;
import com.example.demoo.dtos.TaskDto;
import com.example.demoo.repositories.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService
{
    private ITaskRepository repo;

    @Autowired
    public TaskService(ITaskRepository repo) {
        this.repo = repo;
    }

    public List<Task> GetTasks()
    {
        return repo.findAll();
    }

    public List<Task> GetTasksFromAccount(Account account)
    {
        System.out.println("harja");
        return this.repo.findTasksByAccountId(account.getAccountid());
    }

    public void AddTask(Task newTask)
    {
        newTask.setCompleted(false);
        newTask.setCreatedat(LocalDate.now());
        System.out.println(newTask);

        this.repo.save(newTask);
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

        if(dto.getCompleted() != null && dto.getCompleted() != task.getCompleted())
        {
            task.setCompleted(dto.getCompleted());
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
