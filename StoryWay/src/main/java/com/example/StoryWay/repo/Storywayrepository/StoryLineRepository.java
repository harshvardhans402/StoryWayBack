package com.example.StoryWay.repo.Storywayrepository;

import com.example.StoryWay.model.StoryLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoryLineRepository extends JpaRepository<StoryLine, Integer> {

    public List<StoryLine> findByStory_StoryId(Integer storyId);
    List<StoryLine> findByStory_StoryIdAndPid(Integer storyId, Integer pid);

}
