package com.example.cyan.cyan.questions;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuestionsMapper {

    QuestionsMapper INSTANCE = Mappers.getMapper(QuestionsMapper.class);

    QuestionEntity dtoToEntity(QuestionDTO questionDTO);

    QuestionDTO entityToDTO(QuestionEntity questionEntity);
}