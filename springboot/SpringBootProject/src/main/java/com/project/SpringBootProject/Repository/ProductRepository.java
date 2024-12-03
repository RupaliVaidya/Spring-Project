package com.project.SpringBootProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.SpringBootProject.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
