package com.algozenith.HarmonyHub.controllers;

import com.algozenith.HarmonyHub.models.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/transactions")
public class TransactionController {
    private TransactionServiceInterface transactionService;

    @GetMapping("/{id}")
    public TransactionDto getTransactionById(@PathVariable Long id) throws TransactionNotFoundException {
        Transaction transaction = transactionService.getTransactionById(id);
        return convertToDTO(transaction);
    }

    @GetMapping
    public List<TransactionDto> getTransactions(@RequestParam(required = false) Long productId, @RequestParam(required = false) Long customerId) {
        List<Transaction> transactions = transactionService.findAllTransactions(productId, customerId);
        return transactions.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @PostMapping
    public TransactionDto recordTransaction(@RequestBody Transaction transaction) throws TransactionNotFoundException {
        Transaction transaction1 = transactionService.recordTransaction(transaction);
        return convertToDTO(transaction1);
    }

    @PutMapping
    public TransactionDto updateTransaction(@RequestBody Transaction transaction) throws TransactionNotFoundException {
        Transaction transaction1 = transactionService.updateTransaction(transaction);
        return convertToDTO(transaction1);
    }

    @DeleteMapping("/{id}")
    public void cancelTransaction(@PathVariable Long id) throws TransactionNotFoundException {
        transactionService.cancelTransaction(id);
    }

    private TransactionDto convertToDTO(Transaction transaction) {
        TransactionDto dto = new TransactionDto();
        dto.setId(transaction.getId());
        dto.setProductId(transaction.getProduct().getId());
        dto.setCustomerId(transaction.getCustomer().getId());
        dto.setQuantitiesSold(transaction.getQuantitiesSold());
        dto.setSaleDateTime(transaction.getSaleDateTime());
        dto.setTotalPrice(transaction.getTotalPrice());
        return dto;
    }
}
