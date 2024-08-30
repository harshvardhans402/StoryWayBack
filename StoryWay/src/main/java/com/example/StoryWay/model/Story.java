package com.example.StoryWay.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stories")
public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "story_id")
    private Integer storyId;
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name = "author", referencedColumnName = "user_id", nullable = true)
    private User author; // Assuming you have a User model class

}
