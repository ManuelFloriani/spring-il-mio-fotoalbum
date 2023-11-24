package org.java.finalprove.photoalbum.api;

import jakarta.validation.Valid;
import org.java.finalprove.photoalbum.model.Message;
import org.java.finalprove.photoalbum.model.Photo;
import org.java.finalprove.photoalbum.service.MessageService;
import org.java.finalprove.photoalbum.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/photos")
@CrossOrigin
public class PhotoRestController {
    @Autowired
    private PhotoService photoService;

    @Autowired
    private MessageService messageService;

    // Route /api/photos GET
    @GetMapping
    public List<Photo> index(@RequestParam Optional<String> search) {
        return photoService.getPhotoListAPI(Optional.of(search.orElse("")));
    }

    // Route /api/photos/send POST
    @PostMapping("/send")
    public Message createNewMessage(@Valid @RequestBody Message message) {
        return messageService.createMessage(message);
    }
}
