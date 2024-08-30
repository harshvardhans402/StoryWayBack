package com.example.StoryWay.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "storylines")
@Data

@NoArgsConstructor
@AllArgsConstructor
public class StoryLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @JoinColumn(name = "storyline_id")
       private Integer storylineId;

    @ManyToOne
    @JoinColumn(name = "story_id")
    private Story story;
    @Column(columnDefinition = "int default 0")
    private Integer pid=0;
    @Lob
    private String content;
    private String title;

}
