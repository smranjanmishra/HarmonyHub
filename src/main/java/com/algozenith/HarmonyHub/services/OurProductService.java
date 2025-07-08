package com.algozenith.HarmonyHub.services;

import com.algozenith.HarmonyHub.exceptions.CategoryNotFoundException;
import com.algozenith.HarmonyHub.exceptions.ProductNotFoundException;
import com.algozenith.HarmonyHub.exceptions.SupplierNotFoundException;
import com.algozenith.HarmonyHub.models.Category;
import com.algozenith.HarmonyHub.models.Product;
import com.algozenith.HarmonyHub.models.Supplier;
import com.algozenith.HarmonyHub.repositories.CategoryRepository;
import com.algozenith.HarmonyHub.repositories.ProductRepository;
import com.algozenith.HarmonyHub.repositories.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OurProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final SupplierRepository supplierRepository;

    public OurProductService(ProductRepository productRepository, CategoryRepository categoryRepository, SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.supplierRepository = supplierRepository;
    }

    public Product getProductById(Long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("Product with this productId does not exist");
        }

        return optionalProduct.get();
    }

    public Product addProduct(Product product) throws CategoryNotFoundException, SupplierNotFoundException {
        //getting the category of the product passed by client
        System.out.println("hii");
        Category category = product.getCategory();
        System.out.println("hello");

        //if the category, which is passed in product by client , is not present in database
        //then we are saving the category in the category database

        //TODO
        if (category.getId() == null) {
            product.setCategory(categoryRepository.save(category));
        }

        Supplier supplier = product.getSupplier();
        if (supplier.getSupplierId() == null) {
            product.setSupplier(supplierRepository.save(supplier));
        }
        System.out.println("Worked till supplier.");

        //now saving the product to product database
        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());
        Optional<Supplier> optionalSupplier = supplierRepository.findById(supplier.getSupplierId());
        if (optionalCategory.isEmpty()) {
            throw new CategoryNotFoundException("Category with this CategoryId " + category.getId() + " does not exist");
        }
        if(optionalSupplier.isEmpty()){
            throw new SupplierNotFoundException("Supplier with this SupplierId " + supplier.getSupplierId() + " does not exist");
        }

        product.setCategory(optionalCategory.get());
        product.setSupplier(optionalSupplier.get());
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        List<Product> allProducts = productRepository.findAll();
        return allProducts;
    }

    public List<Product> getProductsByCategory(Long id) throws CategoryNotFoundException {
        List<Product> allProducts = productRepository.findAllByCategory_id(id);
        if(allProducts.isEmpty()){
            throw new CategoryNotFoundException("Category not present in the database");
        }
        return allProducts;
    }

    public Product updateProduct(Product product) throws ProductNotFoundException {
        //getting the id of the product which needs to be updated
        Long productId = product.getId();

        // Retrieving the existing product from the database
        Optional<Product> existingProductOptional = productRepository.findById(productId);

        // Checking if the product exists in the database
        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();
            // Updating the attributes in the product database
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setSupplier(product.getSupplier());
            existingProduct.setStockLevel(product.getStockLevel());

            return productRepository.save(existingProduct);
        } else {
            // Throwing exception if ID not found
            throw new ProductNotFoundException("Product not found, check if the Product exists");
        }
    }

    public void deleteProduct(Long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            productRepository.delete(product);
        } else {
            throw new ProductNotFoundException("Product not found, check if the product exits");
        }
    }

    public List<Product> sortProductsByPrice() throws ProductNotFoundException {
        List<Product> orderedProducts = productRepository.findAllByOrderByPrice();
        if(orderedProducts.isEmpty()){
            throw new ProductNotFoundException("Product not present");
        }

        return orderedProducts;
    }
}