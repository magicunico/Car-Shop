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

    @CrossOrigin("*")
    @PostMapping(value = "/add")
    public void addTransaction(@RequestBody Transaction transaction){transactionService.addTransaction(transaction);}

    @CrossOrigin("*")
    @DeleteMapping(value = "delete/{id}")
    public void deleteInsurance(@PathVariable Long id){transactionService.deleteTransaction(id);}

    @CrossOrigin("*")
    @PutMapping(value = "/update")
    public void updateCustomer(@RequestBody TransactionDTO transactionDTO){transactionService.updateTransaction(transactionDTO);}

    @CrossOrigin("*")
    @GetMapping("/active")
    public List<Transaction> getActive(){
        return transactionService.getActive();
    }
}

