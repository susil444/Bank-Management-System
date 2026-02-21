package com.bank.controller;



import com.bank.entity.Account;
import com.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    // Create new account
    @PostMapping
    public ResponseEntity<Account> create(@RequestParam String name,
                                          @RequestParam Double initialDeposit) {
        Account acc = accountService.createAccount(name, initialDeposit);
        return ResponseEntity.ok(acc);
    }

    // Get account details
    @GetMapping("/{id}")
    public ResponseEntity<Account> get(@PathVariable Long id) {
        return accountService.getAccount(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // Deposit money
    @PostMapping("/{id}/deposit")
    public ResponseEntity<Account> deposit(@PathVariable Long id,
                                           @RequestParam Double amount) {
        Account acc = accountService.deposit(id, amount);
        return ResponseEntity.ok(acc);
    }

    // Withdraw money
    @PostMapping("/{id}/withdraw")
    public ResponseEntity<Account> withdraw(@PathVariable Long id,
                                            @RequestParam Double amount) {
        Account acc = accountService.withdraw(id, amount);
        return ResponseEntity.ok(acc);
    }
}

