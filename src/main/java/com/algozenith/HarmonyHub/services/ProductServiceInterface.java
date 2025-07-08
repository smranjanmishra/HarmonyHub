package com.algozenith.HarmonyHub.services;

import com.algozenith.HarmonyHub.models.Product;

public interface ProductServiceInterface {
    Product createProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(Long id);
    Product getProduct(Long id);
}
