package com.example.demoo.task;

import com.example.demoo.dtos.AccountDto;
import com.example.demoo.dtos.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5000", "http://localhost:8181"})
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
    public List<TaskDto> GetAllTasks()
    {
        System.out.println("Howdy3");
        return TaskService.GetTasks();
    }

    @PostMapping(value = "/MyTasks")
    public List<TaskDto> GetAllTasksFromAccount(@RequestBody AccountDto account)
    {
        System.out.println(account);
        System.out.println("Howdy3");
        return TaskService.GetTasksFromAccount(account);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<String> CreateTask(@RequestBody TaskDto newTask)
    {
        System.out.println(newTask);
       Task newCreatedTask = TaskService.AddTask(newTask);

        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ newCreatedTask.getTaskid() + " }");
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
            TaskService.UpdateTask(new TaskDto(id, task.getTitle(), task.getDescription(), task.getCompleted(), task.getCreatedat(), new AccountDto(task.getAccount().getAccountid(), null, null, null
                    ,null)));
        }
        else
        {
            TaskService.UpdateTask(new TaskDto(id, task.getTitle(), task.getDescription(), task.getCompleted(), task.getCreatedat(), null));
        }

    }

    @DeleteMapping("/{Id}")
    public void DeleteTask(@PathVariable("Id") int Id) {
        TaskService.DeleteTask(Id);
    }


}
