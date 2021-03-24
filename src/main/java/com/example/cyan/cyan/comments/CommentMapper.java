package com.example.cyan.cyan.comments;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(source="comment", target="comment")
    @Mapping(source="createdBy", target="createdBy")
    @Mapping(source="postId", target="postId")
    CommentEntity dtoToEntity(CommentDTO commentDTO);

    @Mapping(source="commentId", target="commentId")
    @Mapping(source="postId", target="postId")
    @Mapping(source="comment", target="comment")
    @Mapping(source="likes", target="likes")
    @Mapping(source="createdBy", target="createdBy")
    @Mapping(source="createdOn", target="createdOn")
    @Mapping(source="updatedOn", target="updatedOn")
    CommentDTO entityToDTO(CommentEntity commentEntity);
}
