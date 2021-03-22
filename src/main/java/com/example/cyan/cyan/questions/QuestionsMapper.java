package com.example.cyan.cyan.questions;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuestionsMapper {
    QuestionsMapper INSTANCE = Mappers.getMapper(QuestionsMapper.class);

    @Mapping(source="question", target="question")
    @Mapping(source="tags", target="tags")
    @Mapping(source="createdBy", target="createdBy")
    QuestionEntity dtoToEntity(QuestionDTO questionDTO);

    @Mapping(source="id", target="id")
    @Mapping(source="question", target="question")
    @Mapping(source="tags", target="tags")
    @Mapping(source="createdBy", target="createdBy")
    @Mapping(source="createdOn", target="createdOn")
    @Mapping(source="updatedOn", target="updatedOn")
    @Mapping(source="comments", target="comments")
    QuestionDTO entityToDTO(QuestionEntity questionEntity);
}