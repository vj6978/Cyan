package com.example.cyan.cyan.comments;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentEntity dtoToEntity(CommentDTO commentDTO);

    CommentDTO entityToDTO(CommentEntity commentEntity);
}
