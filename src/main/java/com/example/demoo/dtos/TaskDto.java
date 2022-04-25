package com.example.demoo.dtos;

import java.time.LocalDate;

public class TaskDto
{
    private int taskid;
    private String Title;
    private String Description;
    private Boolean Completed;
    private LocalDate Createdat;
    private AccountDto Account;

    public TaskDto(int taskid, String title, String discription, Boolean completed, LocalDate createdat, AccountDto account) {
        this.taskid = taskid;
        Title = title;
        Description = discription;
        Completed = completed;
        Createdat = createdat;
        Account = account;
    }

    public TaskDto(String title, String discription, Boolean completed, LocalDate createdat, AccountDto account) {
        Title = title;
        Description = discription;
        Completed = completed;
        Createdat = createdat;
        Account = account;
    }

    public TaskDto(){

    }

    public void setTaskid(int taskid) {
        this.taskid = taskid;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String discription) {
        Description = discription;
    }

    public void setCompleted(Boolean completed) {
        Completed = completed;
    }

    public void setCreatedat(LocalDate createdat) {
        Createdat = createdat;
    }

    public void setAccount(AccountDto account) {
        Account = account;
    }

    public int getTaskid() {
        return taskid;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public Boolean getCompleted() {
        return Completed;
    }

    public LocalDate getCreatedat() {
        return Createdat;
    }

    public AccountDto getAccount() {
        return Account;
    }

    @Override
    public String toString() {
        return "TaskDto{" +
                "taskid=" + taskid +
                ", Title='" + Title + '\'' +
                ", Discription='" + Description + '\'' +
                ", Completed=" + Completed +
                ", Createdat=" + Createdat +
                ", Account=" + Account +
                '}';
    }
}
