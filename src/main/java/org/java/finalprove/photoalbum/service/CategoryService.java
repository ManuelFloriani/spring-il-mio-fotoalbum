package org.java.finalprove.photoalbum.service;

import org.java.finalprove.photoalbum.model.Category;
import org.java.finalprove.photoalbum.repository.CategoryRepository;
import org.java.finalprove.photoalbum.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private PhotoRepository photoRepository;

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
