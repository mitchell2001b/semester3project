package com.example.demoo.account;

import java.time.LocalDate;

public class Account
{
    private Long Id;
    private String Name;
    private String PassWord;
    private LocalDate DateOfBirth;
    private String Email;


    public Account(Long id, String name, LocalDate dateOfBirth, String passWord, String email)
    {
        this.Id = id;
        this.Name = name;
        this.DateOfBirth = dateOfBirth;
        this.Email = email;
        this.PassWord = passWord;

    }

    public Account(String name, LocalDate dateOfBirth, String passWord, String email)
    {
        this.Name = name;
        this.DateOfBirth = dateOfBirth;
        this.Email = email;
        this.PassWord = passWord;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        DateOfBirth = dateOfBirth;
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
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", PassWord='" + PassWord + '\'' +
                ", DateOfBirth=" + DateOfBirth +
                ", Email='" + Email + '\'' +
                '}';
    }
}