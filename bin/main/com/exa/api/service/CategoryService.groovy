package com.exa.api.service

import com.exa.api.entity.Category
import com.exa.api.repository.CategoryRepository

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService{
    
    @Autowired
    private final CategoryRepository CategoryRepository

    public List<Category> findAll(){
        return CategoryRepository.findAll()
    }

    public List<Category> findById(int id){
        return CategoryRepository.findById(id)
    }

    public Category createCategory(Category category) {
        return CategoryRepository.save(category);
    }

    public Category updateCategory(Category category, Integer id) {
        Category updateCategory = CategoryRepository.findById(id).orElse(null);
        if(updateCategory != null) {
            updateCategory.setKd_Kategori(category.getKd_Kategori());
            updateCategory.setNama(category.getNama());
            updateCategory.setKeterangan(category.getKeterangan());
        }
        final Category myCategory = CategoryRepository.save(updateCategory);
        return myCategory;
    }

    public Boolean deleteCategory (Integer id) {
        Category delCategory  = CategoryRepository.findById(id).orElse(null);
        if(delCategory != null) {
            CategoryRepository.delete(delCategory);
            return true;
        }
        return false;
    }
}