package com.example.StoryWay.controller;


import com.example.StoryWay.model.LoginResponse;
import com.example.StoryWay.model.Story;
import com.example.StoryWay.model.StoryLine;
import com.example.StoryWay.model.User;
import com.example.StoryWay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.SysexMessage;

@RestController
public class UserController {

    @Autowired
    private UserService service;


    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);

    }
    @PutMapping("/updateCurrentStory")
    public String updateCurrentStory( @RequestBody  Integer storyId,Integer storylineId){

        System.out.println(storyId +" " +  storylineId);
        return service.updateCurrentStory(storylineId   ,storyId);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody User user) {
        return service.verify(user);
    }
}
