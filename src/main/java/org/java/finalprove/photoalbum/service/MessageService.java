package org.java.finalprove.photoalbum.service;

import org.java.finalprove.photoalbum.model.Message;
import org.java.finalprove.photoalbum.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public Message createMessage(Message message) throws RuntimeException{
        return messageRepository.save(message);
    }

    public List<Message> getAll(){
        return messageRepository.findAll();
    }
}
