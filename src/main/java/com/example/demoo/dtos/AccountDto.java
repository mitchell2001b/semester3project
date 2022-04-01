package com.example.demoo.dtos;

import java.time.LocalDate;

public class AccountDto
{
    private int accountid;
    private String Name;
    private String Password;
    private LocalDate Dateofbirth;
    private String Email;

    public AccountDto(int id, String name, String password, LocalDate dateofbirth, String email) {
        accountid = id;
        Name = name;
        Password = password;
        Dateofbirth = dateofbirth;
        Email = email;
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
