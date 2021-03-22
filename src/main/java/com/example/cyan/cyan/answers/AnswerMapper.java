package com.example.cyan.cyan.answers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnswerMapper {
    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);

    @Mapping(source="questionId", target="questionId")
    @Mapping(source="answer", target="answer")
    @Mapping(source="createdBy", target="createdBy")
    AnswerEntity dtoToEntity(AnswerDTO answerDTO);

    @Mapping(source="id", target="id")
    @Mapping(source="questionId", target="questionId")
    @Mapping(source="answer", target="answer")
    @Mapping(source="likes", target="likes")
    @Mapping(source="createdBy", target="createdBy")
    @Mapping(source="createdOn", target="createdOn")
    @Mapping(source="updatedOn", target="updatedOn")
    @Mapping(source="comments", target="comments")
    AnswerDTO entityToDTO(AnswerEntity answerEntity);
}
