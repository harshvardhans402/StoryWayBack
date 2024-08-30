package com.example.StoryWay.model;


import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class StoryDTO {
    Integer storyId;
    String title;
    String description;
    String author;
    Integer currentStoryLine;

    public StoryDTO(Integer storyId, String title, String description, String authorName) {
        this.storyId = storyId;
        this.title = title;
        this.description = description;
        this.author = authorName;
    }

}
