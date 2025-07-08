package com.algozenith.HarmonyHub.services;

import com.algozenith.HarmonyHub.exceptions.TransactionNotFoundException;
import com.algozenith.HarmonyHub.models.Customer;
import com.algozenith.HarmonyHub.models.Product;
import com.algozenith.HarmonyHub.models.Transaction;
import com.algozenith.HarmonyHub.repositories.CustomerRepository;
import com.algozenith.HarmonyHub.repositories.ProductRepository;
import com.algozenith.HarmonyHub.repositories.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TransactionService implements TransactionServiceInterface {
    private TransactionRepository transactionRepository;
    private ProductRepository productRepository;
    private CustomerRepository customerRepository;

    public List<Transaction> findAllTransactions(Long productId, Long customerId) {
        if (productId != null) {
            Product product = productRepository.findById(productId).orElse(null);
            if (product == null) return Collections.emptyList();

            return product.getTransactions();
        }

        if (customerId != null) {
            Customer customer = customerRepository.findById(customerId).orElse(null);
            if (customer == null) return Collections.emptyList();

            return customer.getTransactions();
        }

        return transactionRepository.findAll();
    }

    public Transaction recordTransaction(Transaction transaction) throws TransactionNotFoundException {
        if (transaction.getId() != null) {
            Optional<Transaction> optionalTransaction = transactionRepository.findById(transaction.getId());
            if (optionalTransaction.isEmpty()) {
                throw new TransactionNotFoundException("Invalid transaction ID");
            }
        }

        Customer customer = transaction.getCustomer();
        if (customer.getId() == null) {
            customer = customerRepository.save(customer);

            if (customer.getTransactions() != null)
                customer.getTransactions().add(transaction);

            transaction.setCustomer(customer);
        }

        Product product = transaction.getProduct();
        if (product.getId() == null) {
            product = productRepository.save(product);

            if (product.getTransactions() != null)
                product.getTransactions().add(transaction);

            transaction.setProduct(product);
        }

        return transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(Transaction transaction) throws TransactionNotFoundException {
        if (transaction.getId() == null) throw new TransactionNotFoundException("Transaction not found");

        Optional<Transaction> optionalTransaction = transactionRepository.findById(transaction.getId());
        if (optionalTransaction.isEmpty()) throw new TransactionNotFoundException("Transaction not found");

        return transactionRepository.save(optionalTransaction.get());
    }

    public void cancelTransaction(Long id) throws TransactionNotFoundException {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
        if (optionalTransaction.isEmpty()) {
            throw new TransactionNotFoundException("Transaction not found");
        }

        transactionRepository.deleteById(id);
    }

    public Transaction getTransactionById(Long id) throws TransactionNotFoundException {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
        if (optionalTransaction.isEmpty()) {
            throw new TransactionNotFoundException("Transaction not found");
        }

        return optionalTransaction.get();
    }
}
