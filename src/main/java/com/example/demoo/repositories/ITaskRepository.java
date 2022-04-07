package com.example.demoo.repositories;

import com.example.demoo.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITaskRepository  extends JpaRepository<Task, Integer>
{
    @Query(value = "SELECT * FROM task where accountid = ?1", nativeQuery = true)
    public List<Task> findTasksByAccountId(int id);
}
