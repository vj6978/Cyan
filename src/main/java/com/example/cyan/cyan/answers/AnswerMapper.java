package com.example.cyan.cyan.answers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnswerMapper {

    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);

    AnswerEntity dtoToEntity(AnswerDTO answerDTO);

    AnswerDTO entityToDTO(AnswerEntity answerEntity);
}
