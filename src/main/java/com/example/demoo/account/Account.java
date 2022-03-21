package com.example.demoo.account;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "account")
public class Account
{
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Name;
    private String Password;
    private LocalDate Dateofbirth;
    @Column(unique=true)
    private String Email;


    public Account(Long id, String name, LocalDate dateOfBirth, String passWord, String email)
    {
        this.Id = id;
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
        return Password;
    }

    public void setPassWord(String passWord) {
        Password = passWord;
    }

    public LocalDate getDateOfBirth() {
        return Dateofbirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
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
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", PassWord='" + Password + '\'' +
                ", DateOfBirth=" + Dateofbirth +
                ", Email='" + Email + '\'' +
                '}';
    }
}