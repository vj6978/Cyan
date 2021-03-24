package com.example.cyan.cyan.questions;

import com.example.cyan.cyan.posts.PostsDTO;
import com.example.cyan.cyan.posts.PostsEntity;
import com.example.cyan.cyan.posts.PostsMapper;
import com.example.cyan.cyan.posts.PostsRepository;
import com.example.cyan.cyan.posts.PostsService;
import com.example.cyan.cyan.posts.constants.PostTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService extends PostsService {
    @Autowired
    private PostsRepository postsRepository;

    @Override
    public boolean accept(PostsDTO postsDTO){
        return postsDTO.getPostType().equals(PostTypes.QUESTION.name());
    }

    @Override
    public PostsDTO post(PostsDTO postsDTO){
        super.post(postsDTO);
        postsDTO.setPostType(PostTypes.QUESTION.name());
        PostsEntity postsEntity = PostsMapper.INSTANCE.dtoToEntity(postsDTO);
        return PostsMapper.INSTANCE.entityToDTO(postsRepository.save(postsEntity));
    }
}
