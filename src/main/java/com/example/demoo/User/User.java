package com.example.demoo.User;

import java.time.LocalDate;

public class User
{
    private Long Id;
    private String Name;
    private String PassWord;
    private LocalDate DateOfBirth;
    private String Email;

    public User(Long id, String name, LocalDate dateOfBirth, String passWord, String email)
    {
        Id = id;
        Name = name;
        DateOfBirth = dateOfBirth;
        Email = email;
        PassWord = passWord;

    }

    public User(String name, LocalDate dateOfBirth, String passWord, String email)
    {
        Name = name;
        DateOfBirth = dateOfBirth;
        Email = email;
        PassWord = passWord;
    }

    public String GetUserName()
    {
        return Name;
    }

    public Long GetUserId()
    {
        return Id;
    }

    public  LocalDate GetDateOfBirth()
    {
        return DateOfBirth;
    }

    public String GetPassWord()
    {
        return PassWord;
    }

    public String GetEmail()
    {
        return Email;
    }

    public void SetPassWord(String newValue)
    {
        PassWord = newValue;
    }

    public void SetEmail(String newValue)
    {
        Email = newValue;
    }

    public void SetName(String newValue)
    {
        Name = newValue;
    }

    public void setId(Long id)
    {
        Id = id;
    }

    public void setDateOfBirth(LocalDate newValue)
    {
        DateOfBirth = newValue;
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
