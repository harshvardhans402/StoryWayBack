package com.example.StoryWay.controller.Storywaycontroller;


import com.example.StoryWay.model.StoryLine;
import com.example.StoryWay.service.StorywayServices.StoryLineService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoryLineController {

    @Autowired
    StoryLineService storylineserv;

    @PostMapping("/addStoryline")
    public String addStoryLIne(@RequestBody  StoryLine storyline){

        return storylineserv.addStoryLine(storyline);
    }



    @GetMapping("/getStoryline/{storyId}")
    public List<StoryLine> getStoryLine(@PathVariable Integer storyId){
        System.out.println("storyId: " + storyId);
        return storylineserv.getStoryLine(storyId);
    }

    @GetMapping("/getStartingStoryline/{storyId}")
    public List<StoryLine> getStartingStoryLine(@PathVariable Integer storyId){
        System.out.println("storyId: " + storyId);
        return storylineserv.getStartingStoryLine(storyId);
    }

    @GetMapping("/deleteStoryline")
    public String deleteStoryLIne(@RequestParam Integer  storyline_id){
        return storylineserv.deleteStoryLine(storyline_id);

    }
}
