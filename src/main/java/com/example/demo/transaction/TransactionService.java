package com.example.demo.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private TransactionRepository transactionRepository;

    @Autowired
     TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

     List<Transaction> getTransactions(){return transactionRepository.findAll();}

     void addTransaction(Transaction transaction){transactionRepository.save(transaction);}

     void deleteTransaction(Long id){
        Transaction transaction = transactionRepository.findById(id).get();
        transaction.setNonactive();
        transactionRepository.save(transaction);
     }

     void updateTransaction(TransactionDTO transactionDTO){
        Transaction transaction = transactionRepository.findById(transactionDTO.getId()).orElseThrow(()->new IllegalArgumentException("Transaction not found"));

        transaction.setDate(transactionDTO.getDate());
        transaction.setPayment(transactionDTO.getPayment());
        transaction.setPlace(transactionDTO.getPlace());
        transaction.setSum(transactionDTO.getSum());
        transaction.setCustomer(transactionDTO.getCustomer());
        transaction.setEmployee(transactionDTO.getEmployee());
        transaction.setCar(transactionDTO.getCar());
        transaction.setInsurance(transactionDTO.getInsurance());

        transactionRepository.save(transaction);
     }
}
