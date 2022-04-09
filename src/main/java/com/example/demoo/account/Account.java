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
    private int role;
    @Column(unique=true)
    private String Email;
    @JsonIgnore
    @OneToMany(mappedBy = "account", orphanRemoval = true)
    public Set<Task> tasks = new HashSet<>();

    public Account(int accountid, String name, String password, LocalDate dateofbirth, int role, String email, Set<Task> tasks) {
        this.accountid = accountid;
        Name = name;
        Password = password;
        Dateofbirth = dateofbirth;
        this.role = role;
        Email = email;
        this.tasks = tasks;
    }

    public Account(String name, String password, LocalDate dateofbirth, int role, String email, Set<Task> tasks) {
        Name = name;
        Password = password;
        Dateofbirth = dateofbirth;
        this.role = role;
        Email = email;
        this.tasks = tasks;
    }

    public Account(int accountid, String name, String password, LocalDate dateofbirth, int role, String email) {
        this.accountid = accountid;
        Name = name;
        Password = password;
        Dateofbirth = dateofbirth;
        this.role = role;
        Email = email;
    }

    public Account(){

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

    public void setPassword(String password) {
        Password = password;
    }

    public LocalDate getDateofbirth() {
        return Dateofbirth;
    }

    public void setDateofbirth(LocalDate dateofbirth) {
        Dateofbirth = dateofbirth;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountid=" + accountid +
                ", Name='" + Name + '\'' +
                ", Password='" + Password + '\'' +
                ", Dateofbirth=" + Dateofbirth +
                ", role=" + role +
                ", Email='" + Email + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}