package com.example.demoo.dtos;

import java.time.LocalDate;

public class TaskDto
{
    private int taskid;
    private String Title;
    private String Discription;
    private Boolean Completed;
    private LocalDate Createdat;
    private AccountDto Account;

    public TaskDto(int taskid, String title, String discription, Boolean completed, LocalDate createdat, AccountDto account) {
        this.taskid = taskid;
        Title = title;
        Discription = discription;
        Completed = completed;
        Createdat = createdat;
        Account = account;
    }

    public int getTaskid() {
        return taskid;
    }

    public String getTitle() {
        return Title;
    }

    public String getDiscription() {
        return Discription;
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
                ", Discription='" + Discription + '\'' +
                ", Completed=" + Completed +
                ", Createdat=" + Createdat +
                ", Account=" + Account +
                '}';
    }
}
