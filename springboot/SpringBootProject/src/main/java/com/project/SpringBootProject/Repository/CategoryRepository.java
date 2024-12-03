package com.project.SpringBootProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.SpringBootProject.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
