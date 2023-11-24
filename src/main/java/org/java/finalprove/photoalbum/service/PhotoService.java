package org.java.finalprove.photoalbum.service;

import org.java.finalprove.photoalbum.controller.exception.PhotoNotFoundException;
import org.java.finalprove.photoalbum.model.Photo;
import org.java.finalprove.photoalbum.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {
    @Autowired
    private PhotoRepository photoRepository;

    public List<Photo> getPhotoList(Optional<String> search) {
        // Se è stato passato un parametro di ricerca
        if (search.isPresent()) {
            // lo prendo e mi faccio ritornare una lista filtrata in base al nome
            return photoRepository.findByTitleContainingIgnoreCase(search.get());
        } else {
            // altrimenti ritorno tutte le photo
            return photoRepository.findAll();
        }
    }

    public Photo getPhotoById(Integer id) {
        Optional<Photo> result = photoRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new PhotoNotFoundException("Photo with ID " + id + ": Not Found");
        }
    }

    public Photo createPhoto(Photo photo) throws RuntimeException {
        photo.setId(null);
        return photoRepository.save(photo);
    }

    public Photo editPhoto(Photo photo) throws PhotoNotFoundException {
        Photo photoToEdit = getPhotoById(photo.getId());
        photoToEdit.setTitle(photo.getTitle());
        photoToEdit.setDescription(photo.getDescription());
        photoToEdit.setImageUrl(photo.getImageUrl());
        photoToEdit.setVisibility(photo.getVisibility());
        photoToEdit.setCategories(photo.getCategories());
        return photoRepository.save(photoToEdit);
    }

    public void deletePhoto(Integer id){
        photoRepository.deleteById(id);
    }
}
