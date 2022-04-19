package com.example.demoo.dtos;

import java.time.LocalDate;

public class AccountDto
{
    private int accountid;
    private String Name;
    private String Password;
    private LocalDate Dateofbirth;
    private int Role;
    private String Email;

    public AccountDto(int id, String name, String password, LocalDate dateofbirth, String email) {
        accountid = id;
        Name = name;
        Password = password;
        Dateofbirth = dateofbirth;
        Email = email;
    }

    public AccountDto(String name, String password, LocalDate dateofbirth, int accountRole, String email) {
        Role = accountRole;
        Name = name;
        Password = password;
        Dateofbirth = dateofbirth;
        Email = email;
    }

    public AccountDto()
    {

    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setDateofbirth(LocalDate dateofbirth) {
        Dateofbirth = dateofbirth;
    }

    public void setRole(int role) {
        Role = role;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getRole() {
        return Role;
    }

    public int getAccountid() {
        return accountid;
    }

    public String getName() {
        return Name;
    }

    public String getPassword() {
        return Password;
    }

    public LocalDate getDateofbirth() {
        return Dateofbirth;
    }

    public String getEmail() {
        return Email;
    }
}
