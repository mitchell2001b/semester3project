package com.example.demoo.task;

import com.example.demoo.account.Account;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "task")
public class Task
{
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskid;
    private String Title;
    private String Discription;
    private LocalDate Createdat;
    @ManyToOne
    @JoinColumn(name = "accountid")
    private Account account;

    public Task(Long id, String title, String discription, LocalDate createdat, Account account) {
        taskid = id;
        Title = title;
        Discription = discription;
        Createdat = createdat;
        this.account = account;
    }

    public Task(String title, String discription, LocalDate createdat, Account account) {
        Title = title;
        Discription = discription;
        Createdat = createdat;
        this.account = account;
    }

    public Task()
    {

    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Long getTaskid() {
        return taskid;
    }

    public void setTaskid(Long taskid) {
        this.taskid = taskid;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDiscription() {
        return Discription;
    }

    public void setDiscription(String discription) {
        Discription = discription;
    }

    public LocalDate getCreatedat() {
        return Createdat;
    }

    public void setCreatedat(LocalDate createdat) {
        Createdat = createdat;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskid=" + taskid +
                ", Title='" + Title + '\'' +
                ", Discription='" + Discription + '\'' +
                ", Createdat=" + Createdat +
                ", account=" + account +
                '}';
    }
}
