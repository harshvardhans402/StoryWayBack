package com.example.StoryWay.controller.Storywaycontroller;

import com.example.StoryWay.model.Story;

import com.example.StoryWay.model.StoryDTO;
import com.example.StoryWay.service.StorywayServices.StoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoryController {
    @Autowired
  private  StoryService storyserv;



    @GetMapping("/stories")
    public List<StoryDTO> getAllStories(){

        return storyserv.getAllStories();
    }

    @PostMapping("/createStory")
    public String saveStory(@RequestBody Story story){

        return storyserv.saveStory(story);
    }

    @PutMapping("/updateStory")
    public String updateStory(@RequestBody Story story){
        return storyserv.saveStory(story);
    }

    @DeleteMapping("/deleteStory")
    public String deleteStory(@RequestBody Integer storyId){
        return storyserv.deleteStory(storyId);

    }
}
