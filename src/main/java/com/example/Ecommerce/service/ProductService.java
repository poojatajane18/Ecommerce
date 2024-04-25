package com.example.Ecommerce.service;

import com.example.Ecommerce.model.Availability;
import com.example.Ecommerce.model.Product;
import java.util.ArrayList;
import com.example.Ecommerce.model.Rating;
import com.example.Ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategoriesContaining(category);
    }

    public List<Product> searchProducts(String keyword) {
        return productRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyword, keyword);
    }

    public List<Product> filterProductsByAttribute(String attributeName, Object attributeValue) {
        return productRepository.findByAttributes(attributeName, attributeValue);
    }

    public void rateProduct(String productId, Rating rating) {
        // Retrieve product by ID
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();

            // Initialize ratings list if null
            if (product.getRatings() == null) {
                product.setRatings(new ArrayList<>());
            }

            // Set productId in the rating (optional, for reference)
            

            // Add the rating to the product's ratings list
            List<Rating> ratings = product.getRatings();
            ratings.add(rating);

            // Save the updated product with the new rating
            productRepository.save(product);
        } else {
            throw new IllegalArgumentException("Product not found with ID: " + productId);
        }
    }
    public void updateProductAvailability(String productId, Availability availability) {
        // Retrieve product by ID
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with ID: " + productId));

        // Update product availability
        product.getAvailability().setInStock(availability.isInStock());
        product.getAvailability().setQuantity(availability.getQuantity());

        // Save the updated product
        productRepository.save(product);
    }
    
    public Product updateProduct(String productId, Product updatedProduct) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();

            // Update all fields of the existing product with the new product details
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setCategories(updatedProduct.getCategories());
            existingProduct.setAttributes(updatedProduct.getAttributes());
            existingProduct.setAvailability(updatedProduct.getAvailability());
            existingProduct.setRatings(updatedProduct.getRatings());

            // Save the updated product
            return productRepository.save(existingProduct);
        } else {
            throw new IllegalArgumentException("Product not found with ID: " + productId);
        }
    }
}
