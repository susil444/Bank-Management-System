package com.bank.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.entity.Account;
import com.bank.repository.AccountRepository;

@Service
@Transactional
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(String holderName, Double initialDeposit) {
        Account acc = new Account(holderName, initialDeposit);
        return accountRepository.save(acc);
    }

    public Optional<Account> getAccount(Long id) {
        return accountRepository.findById(id);
    }

    public Account deposit(Long id, Double amount) {
        Account acc = accountRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Account not found"));
        acc.setBalance(acc.getBalance() + amount);
        return accountRepository.save(acc);
    }

    public Account withdraw(Long id, Double amount) {
        Account acc = accountRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Account not found"));
        if (acc.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }
        acc.setBalance(acc.getBalance() - amount);
        return accountRepository.save(acc);
    }
}

