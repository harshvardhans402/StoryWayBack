package com.example.StoryWay.repo.Storywayrepository;

import com.example.StoryWay.model.Story;
import com.example.StoryWay.model.StoryDTO;
import com.example.StoryWay.model.StoryLine;
import com.example.StoryWay.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface StoryRepository extends JpaRepository<Story,Integer> {


    @Query("SELECT new com.example.StoryWay.model.StoryDTO(s.id, s.title, s.description, a.name) " +
            "FROM Story s JOIN s.author a")
    List<StoryDTO> findAllStoriesWithAuthorName();
    Optional<Story> findByTitleAndAuthor(String title, User author);



}
