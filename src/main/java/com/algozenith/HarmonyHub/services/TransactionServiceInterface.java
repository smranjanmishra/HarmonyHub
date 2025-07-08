package com.algozenith.HarmonyHub.services;

import com.algozenith.HarmonyHub.exceptions.TransactionNotFoundException;
import com.algozenith.HarmonyHub.models.Transaction;

import java.util.List;

public interface TransactionServiceInterface {
    List<Transaction> findAllTransactions(Long productId, Long customerId);
    Transaction recordTransaction(Transaction transaction) throws TransactionNotFoundException;
    Transaction updateTransaction(Transaction transaction) throws TransactionNotFoundException;
    void cancelTransaction(Long id) throws TransactionNotFoundException;
    Transaction getTransactionById(Long id) throws TransactionNotFoundException;
}
