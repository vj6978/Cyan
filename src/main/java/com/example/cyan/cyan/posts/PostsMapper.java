package com.example.cyan.cyan.posts;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostsMapper {
    PostsMapper INSTANCE = Mappers.getMapper(PostsMapper.class);

    @Mapping(source="content", target="content")
    @Mapping(source="tags", target="tags")
    @Mapping(source="postType", target="postType")
    @Mapping(source="createdBy", target="createdBy")
    PostsEntity dtoToEntity(PostsDTO postsDTO);

    @Mapping(source="postId", target="postId")
    @Mapping(source="content", target="content")
    @Mapping(source="likes", target="likes")
    @Mapping(source="tags", target="tags")
    @Mapping(source="postType", target="postType")
    @Mapping(source="createdBy", target="createdBy")
    @Mapping(source="createdOn", target="createdOn")
    @Mapping(source="updatedOn", target="updatedOn")
    PostsDTO entityToDTO(PostsEntity postsEntity);
}
