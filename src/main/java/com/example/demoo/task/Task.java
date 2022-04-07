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
    private int taskid;
    private String Title;
    private String Discription;
    private Boolean Completed;
    private LocalDate Createdat;
    @ManyToOne
    @JoinColumn(name = "accountid")
    private Account account;

    public Task(int taskid, String title, String discription, Boolean completed, LocalDate createdat, Account account) {

        this.taskid = taskid;
        Title = title;
        Discription = discription;
        Completed = completed;
        Createdat = createdat;
        this.account = account;
    }

    public Task(String title, String discription, Boolean completed, LocalDate createdat, Account account) {

        Title = title;
        Discription = discription;
        Completed = completed;
        Createdat = createdat;
        this.account = account;
    }

    public Task()
    {

    }

    public int getTaskid() {
        return taskid;
    }

    public void setTaskid(int taskid) {
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

    public Boolean getCompleted() {
        return Completed;
    }

    public void setCompleted(Boolean completed) {
        Completed = completed;
    }

    public LocalDate getCreatedat() {
        return Createdat;
    }

    public void setCreatedat(LocalDate createdat) {
        Createdat = createdat;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskid=" + taskid +
                ", Title='" + Title + '\'' +
                ", Discription='" + Discription + '\'' +
                ", Completed=" + Completed +
                ", Createdat=" + Createdat +
                ", account=" + account +
                '}';
    }
}
