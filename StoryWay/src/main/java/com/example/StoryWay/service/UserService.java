package com.example.StoryWay.service;

import com.example.StoryWay.model.LoginResponse;
import com.example.StoryWay.model.Story;
import com.example.StoryWay.model.StoryLine;
import com.example.StoryWay.model.User;
import com.example.StoryWay.repo.Storywayrepository.UserRepository;
import com.example.StoryWay.service.JWTService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private UserRepository repo;


    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return user;
    }

    public LoginResponse verify(User user) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        if (authentication.isAuthenticated()) {

            String token = jwtService.generateToken(user.getEmail());
            User authenticatedUser = repo.findByEmail(user.getEmail());
            System.out.println(authenticatedUser.getEmail());

            return new LoginResponse(token, authenticatedUser.getEmail(), authenticatedUser.getName());

        } else {
            return null;
        }
    }


    public String updateCurrentStory (Integer storyLine, Integer story) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = userDetails.getUsername();
        User user=repo.findByEmail(email);


        user.setCurrent_story_id(story);
        user.setCurrent_storyline_id(storyLine);
        System.out.println(storyLine +"sfsdfs "+story);
        repo.save(user);

        return "updated current story";
    }
}
