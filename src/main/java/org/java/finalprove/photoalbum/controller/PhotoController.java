package org.java.finalprove.photoalbum.controller;

import jakarta.validation.Valid;
import org.java.finalprove.photoalbum.exception.PhotoNotFoundException;
import org.java.finalprove.photoalbum.model.Photo;
import org.java.finalprove.photoalbum.service.CategoryService;
import org.java.finalprove.photoalbum.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/photos")
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    @Autowired
    private CategoryService categoryService;

    // Rotta photos
    @GetMapping
    public String index(@RequestParam Optional<String> search, Model model) {
        model.addAttribute("photoList", photoService.getPhotoList(search));
        return "photos/list";
    }

    // Rotta photos -> show
    @GetMapping("/show/{id}")
    public String show(@PathVariable Integer id, Model model) {
        try{
            Photo photo = photoService.getPhotoById(id);
            model.addAttribute("photo", photo);
            return "photos/show";
        } catch (PhotoNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    // Rotta photos -> create GET
    @GetMapping("/create")
    public String createGet(Model model){
        model.addAttribute("photo", new Photo());
        model.addAttribute("categoryList", categoryService.getAll());
        return "photos/create";
    }

    // Rotta photos -> create POST
    @PostMapping("/create")
    public String createPost(Model model, @Valid @ModelAttribute("photo") Photo formPhoto, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            model.addAttribute("categoryList", categoryService.getAll());
            return "photos/create";
        }
        Photo savedPhoto = photoService.createPhoto(formPhoto);
        return "redirect:/photos/show/" + savedPhoto.getId();

    }

    // Rotta photos -> edit GET
    @GetMapping("/edit/{id}")
    public String editGet(@PathVariable Integer id, Model model){
        try{
            model.addAttribute("photo", photoService.getPhotoById(id));
            model.addAttribute("categoryList", categoryService.getAll());
            return "photos/edit";
        } catch (PhotoNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    // Rotta photos -> edit POST
    @PostMapping("/edit/{id}")
    public String editPost(@PathVariable Integer id,
                           @Valid
                           @ModelAttribute("photo")
                           Photo formPhoto,
                           BindingResult bindingResult,
                           Model model){
        if(bindingResult.hasErrors()) {
            model.addAttribute("categoryList", categoryService.getAll());
            return "photos/edit";
        }
        try{
            Photo savedPhoto = photoService.editPhoto(formPhoto);
            return "redirect:/photos/show/" + savedPhoto.getId();
        } catch (PhotoNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    // Rotta photos -> delete
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            Photo photoToDelete = photoService.getPhotoById(id);
            photoService.deletePhoto(id);
            redirectAttributes.addFlashAttribute("message", "Photo" + photoToDelete.getTitle() + "deleted successfully");
            return "redirect:/photos";
        } catch (PhotoNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

}
