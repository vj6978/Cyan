package com.example.cyan.cyan.comments;

import org.springframework.stereotype.Component;

@Component
public class CommentMapper {
    public CommentEntity dtoToEntity(CommentDTO commentDTO){
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setComment(commentDTO.getComment());
        commentEntity.setLikes(commentDTO.getLikes());
        commentEntity.setCreatedBy(commentDTO.getCreatedBy());
        commentEntity.setCreatedOn(commentDTO.getCreatedOn());
        commentEntity.setUpdatedOn(commentDTO.getUpdatedOn());
        return commentEntity;
    }

    public CommentDTO entityToDTO(CommentEntity commentEntity){
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(commentEntity.getId());
        commentDTO.setComment(commentEntity.getComment());
        commentDTO.setLikes(commentEntity.getLikes());
        commentDTO.setCreatedBy(commentEntity.getCreatedBy());
        commentDTO.setCreatedOn(commentEntity.getCreatedOn());
        commentDTO.setUpdatedOn(commentEntity.getUpdatedOn());
        return commentDTO;
    }
}
