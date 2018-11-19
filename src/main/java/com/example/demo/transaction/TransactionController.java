package com.example.demo.transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/all")
    public List<Transaction> getAll(){return transactionService.getTransactions();}

    @PostMapping(value = "/add")
    public void addTransaction(@RequestBody Transaction transaction){transactionService.addTransaction(transaction);}
}

