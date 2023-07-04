package model.entities;

import model.exception.DomainException;

import java.util.AbstractCollection;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawlLimit;

    public Account() {

    }

    public Account(Integer number, String holder, Double balance, Double withdrawlLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawlLimit = withdrawlLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawlLimit() {
        return withdrawlLimit;
    }

    public void setWithdrawlLimit(Double withdrawlLimit) {
        this.withdrawlLimit = withdrawlLimit;
    }

    public void deposit(Double amount) {
        this.balance += amount;
    }

    public void withdraw(Double amount) throws DomainException{
        if (this.balance == 0) {
            throw new DomainException("Error: balance is empty");
        }
        if (amount > this.withdrawlLimit) {
            throw new DomainException("Error: The quantity exceeds the value limit");
        }
        this.balance -= amount;
    }
}
