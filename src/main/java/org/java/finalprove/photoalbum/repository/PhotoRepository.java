package org.java.finalprove.photoalbum.repository;

import org.java.finalprove.photoalbum.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {
    // Here you can define custom queries
    List<Photo> findByTitleContainingIgnoreCase(String titleKeyword); // This method returns a list of photos that match the title passed as a parameter

    List<Photo> findByTitleContainingIgnoreCaseAndVisibilityTrue(String titleKeyword);
    List<Photo> findAllByVisibilityTrue();
}
