package org.java.finalprove.photoalbum.service;

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
}
