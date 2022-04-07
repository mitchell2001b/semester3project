package com.example.demoo.task;

import com.example.demoo.account.Account;
import com.example.demoo.dtos.AccountDto;
import com.example.demoo.dtos.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "api/v1/task")
public class TaskController
{
    private final TaskService TaskService;

    @Autowired
    public TaskController(TaskService service)
    {
        this.TaskService = service;
    }


    @GetMapping
    public List<Task> GetAllTasks()
    {
        System.out.println("Howdy3");
        return TaskService.GetTasks();
    }

    @GetMapping(value = "/tasksfromaccount")
    public List<Task> GetAllTasksFromAccount(@RequestBody Account account)
    {
        System.out.println("Howdy3");
        return TaskService.GetTasksFromAccount(account);
    }

    @PostMapping(value = "/create")
    public void CreateTask(@RequestBody Task newTask)
    {
        System.out.println(newTask);

        TaskService.AddTask(newTask);
    }

    @GetMapping("/{Id}")
    public Optional<Task> GetTaskById(@PathVariable int Id)
    {
        System.out.println(Id + "joo");
        return TaskService.SelectTaskById(Id);
    }

    @PutMapping("/{Id}")
    public void UpdateTask(@PathVariable("Id") int id, @RequestBody Task task)
    {
        System.out.println(id + "het id is");
        if(task.getAccount() != null)
        {
            TaskService.UpdateTask(new TaskDto(id, task.getTitle(), task.getDiscription(), task.getCompleted(), task.getCreatedat(), new AccountDto(task.getAccount().getAccountid(), null, null, null
                    ,null)));
        }
        else
        {
            TaskService.UpdateTask(new TaskDto(id, task.getTitle(), task.getDiscription(), task.getCompleted(), task.getCreatedat(), null));
        }

    }


}
