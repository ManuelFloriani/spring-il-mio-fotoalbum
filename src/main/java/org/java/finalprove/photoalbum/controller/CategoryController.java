package org.java.finalprove.photoalbum.controller;

import jakarta.validation.Valid;
import org.java.finalprove.photoalbum.exception.CategoryNameUniqueException;
import org.java.finalprove.photoalbum.exception.CategoryNotFoundException;
import org.java.finalprove.photoalbum.model.Category;
import org.java.finalprove.photoalbum.repository.CategoryRepository;
import org.java.finalprove.photoalbum.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    // Rotta categories
    @GetMapping
    public String index(Model model) {
        model.addAttribute("categoryList", categoryService.getAll());
        model.addAttribute("categoryObj", new Category());
        return "categories/list";
    }

    // Rotta categories/create
    @PostMapping
    public String create(@Valid @ModelAttribute("categoryObj") Category formCategory, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            model.addAttribute("categoryList", categoryService.getAll());
            return "categories/list";
        }
        try{
            categoryService.save(formCategory);
            redirectAttributes.addFlashAttribute("message", "Category successfully created");
            return "redirect:/categories";
        } catch (CategoryNameUniqueException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Category" + formCategory.getName() + " already exists");
            return "redirect:/categories";
        }
    }

    // Rotta categories/delete
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        try{
            Category categoryToDelete = categoryService.getCategoryById(id);
            categoryService.deleteCategoryWithAssociations(id);
            redirectAttributes.addFlashAttribute("message", "Category " + categoryToDelete.getName() + " successfully deleted");
            return "redirect:/categories";
        } catch (CategoryNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

}
