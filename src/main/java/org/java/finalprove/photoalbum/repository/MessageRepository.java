package org.java.finalprove.photoalbum.repository;

import org.java.finalprove.photoalbum.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
