package com.example.cyan.cyan.posts;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public abstract class PostsService {
    @Autowired
    private PostsRepository postsRepository;

    public abstract boolean accept(PostsDTO postsDTO);

    public PostsDTO post(PostsDTO postsDTO){
        postsDTO.setLikes(0);
        postsDTO.setCreatedOn(LocalDateTime.now());
        postsDTO.setUpdatedOn(postsDTO.getCreatedOn());
        return postsDTO;
    }


}
