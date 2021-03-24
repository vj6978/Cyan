package com.example.cyan.cyan.posts;

import com.example.cyan.cyan.constants.ErrorConstants;
import com.example.cyan.cyan.exceptions.PostNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GenericPostServices {
    @Autowired
    private PostsRepository postsRepository;

    public List<PostsDTO> getAllPostsForAUser(String createdBy){
        return postsRepository.findByCreatedBy(createdBy).stream()
                .map(PostsMapper.INSTANCE::entityToDTO).collect(Collectors.toList());
    }

    public List<PostsDTO> getPostByTag(String tag){
        return postsRepository.findAll((Pageable) PostsJPAHelperSpecification.containsTag(tag))
                .stream().map(PostsMapper.INSTANCE::entityToDTO).collect(Collectors.toList());
    }

    public List<PostsDTO> getPostByKeyword(String keyword){
        return postsRepository.findAll((Pageable) PostsJPAHelperSpecification.containsKeywordInQuestion(keyword))
                .stream().map(PostsMapper.INSTANCE::entityToDTO).collect(Collectors.toList());
    }

    public PostsDTO getPostById(String postId) throws PostNotFoundException {
        Optional<PostsEntity> postsEntity = postsRepository.findById(postId);
        if(postsEntity.isEmpty())
        {
            throw new PostNotFoundException(ErrorConstants.NO_POST_FOUND);
        }
        return PostsMapper.INSTANCE.entityToDTO(postsEntity.get());
    }

    public PostsDTO put(PostsDTO postsDTO) throws PostNotFoundException {
        Optional<PostsEntity> postsEntity = postsRepository.findById(postsDTO.getPostId());
        if(postsEntity.isEmpty())
        {
            throw new PostNotFoundException(ErrorConstants.NO_POST_FOUND);
        }
        PostsEntity post = postsEntity.get();
        post.setPostId(postsDTO.getPostId());
        post.setContent(postsDTO.getContent());
        post.setPostType(postsDTO.getPostType());
        post.setCreatedBy(postsDTO.getCreatedBy());
        post.setTags(postsDTO.getTags());
        post.setUpdatedOn(postsDTO.getUpdatedOn());
        post.setCreatedOn(postsDTO.getCreatedOn());
        return PostsMapper.INSTANCE.entityToDTO(postsRepository.save(post));
    }

    public void delete(String postId) throws PostNotFoundException {
        Optional<PostsEntity> postsEntity = postsRepository.findById(postId);
        if(postsEntity.isEmpty())
        {
            throw new PostNotFoundException(ErrorConstants.NO_POST_FOUND);
        }
        postsRepository.delete(postsEntity.get());
    }

    public PostsDTO react(PostReactionDTO postReactionDTO) throws PostNotFoundException {
        Optional<PostsEntity> postsEntity = postsRepository.findById(postReactionDTO.getPostId());
        if(postsEntity.isEmpty())
        {
            throw new PostNotFoundException(ErrorConstants.NO_POST_FOUND);
        }
        PostsEntity post = postsEntity.get();
        post.setLikes(post.getLikes() + postReactionDTO.getReactionScore());
        return PostsMapper.INSTANCE.entityToDTO(postsRepository.save(post));
    }
}
