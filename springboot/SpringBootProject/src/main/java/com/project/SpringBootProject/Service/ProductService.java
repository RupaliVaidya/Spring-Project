package com.project.SpringBootProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.SpringBootProject.Entity.Product;
import com.project.SpringBootProject.Repository.ProductRepository;



 
@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	

    
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElse(null);}
        
        public Product getProductWithCategory(Long id) {
            Product product = productRepository.findById(id)
                    .orElse(null);
            product.getCategory();
            return product;
        
    }

  
    public Product updateProduct(Long id, Product updatedProduct) {
        Product existingProduct = productRepository.findById(id)
                .orElse(null);

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setCategory(updatedProduct.getCategory());
        

        return productRepository.save(existingProduct);
    }

    
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElse(null);

        productRepository.delete(product);
    }
}
