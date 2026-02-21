package com.bank.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountHolderName;
    private Double balance;

    // default constructor
    public Account() {}

    public Account(String accountHolderName, Double balance) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // getters & setters
    public Long getId() { return id; }
    public String getAccountHolderName() { return accountHolderName; }
    public void setAccountHolderName(String name) { this.accountHolderName = name; }
    public Double getBalance() { return balance; }
    public void setBalance(Double balance) { this.balance = balance; }
}

