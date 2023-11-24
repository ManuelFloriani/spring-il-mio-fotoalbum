package org.java.finalprove.photoalbum.service;

import jakarta.transaction.Transactional;
import org.java.finalprove.photoalbum.exception.CategoryNameUniqueException;
import org.java.finalprove.photoalbum.exception.CategoryNotFoundException;
import org.java.finalprove.photoalbum.model.Category;
import org.java.finalprove.photoalbum.model.Photo;
import org.java.finalprove.photoalbum.repository.CategoryRepository;
import org.java.finalprove.photoalbum.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private PhotoRepository photoRepository;

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category save(Category category) throws CategoryNameUniqueException {
        if (categoryRepository.existsByName(category.getName())) {
            throw new CategoryNameUniqueException("Category name must be unique");
        }
        category.setName(category.getName().toLowerCase());
        return categoryRepository.save(category);
    }

    public Category getCategoryById(Integer id) throws CategoryNotFoundException {
        Optional<Category> result = categoryRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new CategoryNotFoundException("Category with ID " + id + ": Not Found");
        }
    }

    @Transactional
    public void deleteCategoryWithAssociations(Integer id){
        Category categoryToDelete = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category with ID " + id + ": Not Found"));
        for (Photo photo : photoRepository.findAll()){
            photo.getCategories().remove(categoryToDelete);
        }
        categoryRepository.delete(categoryToDelete);
    }
}
