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
    public List<TaskDto> getAllTasks()
    {
        return TaskService.getTasks();
    }

    @PostMapping(value = "/MyTasks")
    public List<TaskDto> getAllTasksFromAccount(@RequestBody AccountDto account)
    {
        return TaskService.getTasksFromAccount(account);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<String> createTask(@RequestBody TaskDto newTask)
    {
        System.out.println(newTask);
       Task newCreatedTask = TaskService.addTask(newTask);

        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ newCreatedTask.getTaskid() + " }");
    }

    @GetMapping("/{Id}")
    public Optional<Task> getTaskById(@PathVariable int Id)
    {
        return TaskService.selectTaskById(Id);
    }

    @PutMapping("/{Id}")
    public void updateTask(@PathVariable("Id") int id, @RequestBody TaskDto task)
    {
        if(task.getAccount() != null)
        {
            TaskService.updateTask(new TaskDto(id, task.getTitle(), task.getDescription(), task.getCompleted(), task.getCreatedat(), new AccountDto(task.getAccount().getAccountid(), null, null, null
                    ,null)));
        }
        else
        {
            TaskService.updateTask(new TaskDto(id, task.getTitle(), task.getDescription(), task.getCompleted(), task.getCreatedat(), null));
        }

    }

    @DeleteMapping("/{Id}")
    public void deleteTask(@PathVariable("Id") int Id) {
        TaskService.deleteTask(Id);
    }


}
