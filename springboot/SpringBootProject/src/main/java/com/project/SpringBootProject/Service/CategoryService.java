package com.project.SpringBootProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.SpringBootProject.Entity.Category;
import com.project.SpringBootProject.Repository.CategoryRepository;




@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	 
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    
    public Page<Category> getAllCategories(Pageable pageable) {
    	return categoryRepository.findAll(pageable);
    }

    
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    
    public Category updateCategory(Long id, Category updatedCategory) {
        Category existingCategory = categoryRepository.findById(id)
                .orElse(null);
        
        existingCategory.setName(updatedCategory.getName());
        

        return categoryRepository.save(existingCategory);
    }

   
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElse(null);
        
        categoryRepository.delete(category);
    }
}
