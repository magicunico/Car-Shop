package com.example.demo.transaction;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getTransactions(){return transactionRepository.findAll();}

    public void addTransaction(Transaction transaction){transactionRepository.save(transaction);}

}
