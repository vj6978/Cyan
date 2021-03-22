package com.example.cyan.cyan.questions;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuestionsMapper {

    QuestionsMapper INSTANCE = Mappers.getMapper(QuestionsMapper.class);

//    @Mapping(source="id", target="id")
//    @Mapping(source="question", target="question")
//    @Mapping(source="tags", target="tags")
//    @Mapping(source="comments", target="comments")
//    @Mapping(source="createdBy", target="createdBy")
//    @Mapping(source="createdOn", target="createdOn")
//    @Mapping(source="updatedOn", target="updatedOn")
    QuestionEntity dtoToEntity(QuestionDTO questionDTO);

//    @Mapping(source="id", target="id")
//    @Mapping(source="question", target="question")
//    @Mapping(source="tags", target="tags")
//    @Mapping(source="comments", target="comments")
//    @Mapping(source="createdBy", target="createdBy")
//    @Mapping(source="createdOn", target="createdOn")
//    @Mapping(source="updatedOn", target="updatedOn")
    QuestionDTO entityToDTO(QuestionEntity questionEntity);
}