package com.example.cyan.cyan.posts;

import com.example.cyan.cyan.comments.CommentService;
import com.example.cyan.cyan.constants.ErrorConstants;
import com.example.cyan.cyan.exceptions.PostNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostsService {
    @Autowired
    private PostsRepository postsRepository;
    @Autowired
    private CommentService commentService;

    public List<PostsTemplateDTO> prepareUserPosts(String createdBy){
        List<PostsTemplateDTO> posts = new ArrayList<>();
        //Get Posts
        List<PostsDTO> postsForUser = getAllPostsForAUser(createdBy);
        if(!postsForUser.isEmpty()) {
            for (PostsDTO post : postsForUser) {
                PostsTemplateDTO postsTemplateDTO = new PostsTemplateDTO();
                postsTemplateDTO.setPost(post);
                postsTemplateDTO.setCommentDTO(commentService.getAllCommentsOnAPost(post.getPostId()));
                posts.add(postsTemplateDTO);
            }
        }
        return posts;
    }

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

    public PostsDTO saveNewPost(PostsDTO postsDTO){
        postsDTO.setLikes(0);
        postsDTO.setCreatedOn(LocalDateTime.now());
        postsDTO.setUpdatedOn(postsDTO.getCreatedOn());
        PostsEntity postsEntity = PostsMapper.INSTANCE.dtoToEntity(postsDTO);
        return PostsMapper.INSTANCE.entityToDTO(postsRepository.save(postsEntity));
    }

    public PostsDTO updatePost(PostsDTO postsDTO) throws PostNotFoundException {
        Optional<PostsEntity> postsEntity = postsRepository.findById(postsDTO.getPostId());
        if(postsEntity.isEmpty())
        {
            throw new PostNotFoundException(ErrorConstants.NO_POST_FOUND);
        }
        PostsEntity post = postsEntity.get();
        post.setPostId(postsDTO.getPostId());
        post.setPostType(postsDTO.getPostType());
        post.setContent(postsDTO.getContent());
        post.setCreatedBy(postsDTO.getCreatedBy());
        post.setTags(postsDTO.getTags());
        post.setUpdatedOn(postsDTO.getUpdatedOn());
        post.setCreatedOn(postsDTO.getCreatedOn());
        return PostsMapper.INSTANCE.entityToDTO(postsRepository.save(post));
    }

    public PostsDTO reactToPost(PostReactionDTO postReactionDTO) throws PostNotFoundException {
        Optional<PostsEntity> postsEntity = postsRepository.findById(postReactionDTO.getPostId());
        if(postsEntity.isEmpty())
        {
            throw new PostNotFoundException(ErrorConstants.NO_POST_FOUND);
        }
        PostsEntity post = postsEntity.get();
        post.setLikes(post.getLikes() + postReactionDTO.getReactionScore());
        return PostsMapper.INSTANCE.entityToDTO(postsRepository.save(post));
    }

    public void deletePostById(String postId) throws PostNotFoundException {
        Optional<PostsEntity> postsEntity = postsRepository.findById(postId);
        if(postsEntity.isEmpty())
        {
            throw new PostNotFoundException(ErrorConstants.NO_POST_FOUND);
        }
        postsRepository.delete(postsEntity.get());
    }
}
