package com.example.StoryWay.service.StorywayServices;

import com.example.StoryWay.model.Story;
import com.example.StoryWay.model.StoryLine;
import com.example.StoryWay.repo.Storywayrepository.StoryLineRepository;
import com.example.StoryWay.repo.Storywayrepository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class StoryLineService {
    @Autowired
    StoryLineRepository storylinerepo;
    @Autowired
    StoryRepository storyrepo;


    public String addStoryLine(StoryLine storyLine) {
        Optional<Story> storyExist= storyrepo.findById(storyLine.getStory().getStoryId());
        StoryLine  savedStoryLine=null;
        Story s=null;
        if(storyExist.isPresent()) {
            List<StoryLine> storylines = storylinerepo.findByStory_StoryId(storyExist.get().getStoryId());
            s=storyExist.get();
            storyLine.setStory(s);
            storylinerepo.save(storyLine);
            System.out.println("Harshvardhan");
        }



//        Optional<StoryLine> storyline=storylinerepo.findById(storyLine.getStorylineId());

        return "StoryLine Added";


    }

    public List<StoryLine> getStoryLine(Integer story_id) {

    List<StoryLine> storyLine=   storylinerepo.findByStory_StoryId(story_id);
        return storyLine;


    }


    public List<StoryLine> getStartingStoryLine(Integer story_id) {

        List<StoryLine> storyLine=   storylinerepo.findByStory_StoryIdAndPid(story_id,0);
        return storyLine;


    }

    public String deleteStoryLine(Integer storyline_id) {

          storylinerepo.deleteById(storyline_id);
        return "StoryLine deleted";


    }
}
