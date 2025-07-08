package com.algozenith.HarmonyHub.services;

import com.algozenith.HarmonyHub.exceptions.CategoryNotFoundException;
import com.algozenith.HarmonyHub.exceptions.ProductNotFoundException;
import com.algozenith.HarmonyHub.exceptions.SupplierNotFoundException;
import com.algozenith.HarmonyHub.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id) throws ProductNotFoundException;
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(Long id) throws CategoryNotFoundException;
    Product addProduct(Product product) throws CategoryNotFoundException, SupplierNotFoundException;
    Product updateProduct(Product product) throws ProductNotFoundException;
    void deleteProduct(Long id) throws ProductNotFoundException;
    List<Product> sortProductsByPrice() throws ProductNotFoundException;
}
