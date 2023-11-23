package org.java.finalprove.photoalbum.controller;

import org.java.finalprove.photoalbum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepository userRepository;

    //"/users"
    @GetMapping
    public String index(Model model){
        model.addAttribute("userList", userRepository.findAll());
        return "users/index";
    }
}
