package com.example.cyan.cyan.comments;

import com.example.cyan.cyan.constants.ErrorConstants;
import com.example.cyan.cyan.exceptions.CommentNoFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<CommentDTO> getAllCommentsOnAPost(String postId){
        return commentRepository.findByPostId(postId).stream()
                .map(CommentMapper.INSTANCE::entityToDTO).collect(Collectors.toList());
    }

    public CommentDTO postComment(CommentDTO commentDTO){
        commentDTO.setLikes(0);
        commentDTO.setCreatedOn(LocalDateTime.now());
        commentDTO.setUpdatedOn(commentDTO.getCreatedOn());
        CommentEntity commentEntity = CommentMapper.INSTANCE.dtoToEntity(commentDTO);
        return CommentMapper.INSTANCE.entityToDTO(commentRepository.save(commentEntity));
    }

    public CommentDTO putComment(CommentDTO commentDTO) throws CommentNoFoundException {
        Optional<CommentEntity> commentEntity = commentRepository.findById(commentDTO.getCommentId());
        if(commentEntity.isEmpty()){
            throw new CommentNoFoundException(ErrorConstants.NO_COMMENT_FOUND);
        }
        CommentEntity comment = commentEntity.get();
        comment.setCommentId(commentDTO.getCommentId());
        comment.setComment(commentDTO.getComment());
        comment.setLikes(commentDTO.getLikes());
        comment.setPostId(commentDTO.getPostId());
        comment.setCreatedBy(commentDTO.getCreatedBy());
        comment.setCreatedOn(commentDTO.getCreatedOn());
        comment.setUpdatedOn(commentDTO.getUpdatedOn());
        return CommentMapper.INSTANCE.entityToDTO(commentRepository.save(comment));
    }

    public void deleteComment(String id) throws CommentNoFoundException {
        Optional<CommentEntity> commentEntity = commentRepository.findById(id);
        if(commentEntity.isEmpty()){
            throw new CommentNoFoundException(ErrorConstants.NO_COMMENT_FOUND);
        }
        commentRepository.delete(commentEntity.get());
    }
}
