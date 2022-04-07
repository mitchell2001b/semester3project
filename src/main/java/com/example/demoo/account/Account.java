package com.example.demoo.account;

import com.example.demoo.task.Task;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "account")
public class Account
{
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountid;
    private String Name;
    private String Password;
    private LocalDate Dateofbirth;
    @Column(unique=true)
    private String Email;
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    public Set<Task> tasks = new HashSet<>();

    public Account(int accountid, String name, String password, LocalDate dateofbirth, String email, Set<Task> tasks) {
        this.accountid = accountid;
        Name = name;
        Password = password;
        Dateofbirth = dateofbirth;
        Email = email;
        this.tasks = tasks;
    }

    public Account(int id, String name, LocalDate dateOfBirth, String passWord, String email)
    {
        this.accountid = id;
        this.Name = name;
        this.Dateofbirth = dateOfBirth;
        this.Email = email;
        this.Password = passWord;

    }

    public Account(String name, LocalDate dateOfBirth, String passWord, String email)
    {
        this.Name = name;
        this.Dateofbirth = dateOfBirth;
        this.Email = email;
        this.Password = passWord;
    }

    public Account()
    {

    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String passWord) {
        Password = passWord;
    }

    public LocalDate getDateofbirth() {
        return Dateofbirth;
    }

    public void setDateofbirth(LocalDate dateOfBirth) {
        Dateofbirth = dateOfBirth;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + accountid +
                ", Name='" + Name + '\'' +
                ", Password='" + Password + '\'' +
                ", Dateofbirth=" + Dateofbirth +
                ", Email='" + Email + '\'' +
                '}';
    }
}