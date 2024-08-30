package com.example.StoryWay.service.StorywayServices;

import com.example.StoryWay.model.Story;
import com.example.StoryWay.model.StoryDTO;
import com.example.StoryWay.model.User;
import com.example.StoryWay.repo.Storywayrepository.StoryRepository;
import com.example.StoryWay.repo.Storywayrepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryService {

    @Autowired
    private StoryRepository storyrepo;
    @Autowired
    private UserRepository userrepo;

    public List<StoryDTO> getAllStories(){
        return storyrepo.findAllStoriesWithAuthorName();
    }

    public String saveStory(Story story) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = userDetails.getUsername();
        User user=userrepo.findByEmail(email);


        boolean exist= storyrepo.findByTitleAndAuthor(story.getTitle().toLowerCase(),user).isPresent();
        if(exist) {
        return "Story Already Exists";
        }else {
            story.setAuthor(user);
            storyrepo.save(story);
            return "Story Created";
        }
    }

    public String deleteStory(Integer storyId){
        storyrepo.deleteById(storyId);
        return "Story Deleted";
    }
}
