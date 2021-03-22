package com.example.cyan.cyan.answers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnswerMapper {

    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);

//    @Mapping(source="questionId", target="questionId")
//    @Mapping(source="answer", target="answer")
    AnswerEntity dtoToEntity(AnswerDTO answerDTO);
//    {
//        AnswerEntity answerEntity = new AnswerEntity();
//        answerEntity.setAnswer(answerDTO.getAnswer());
//        answerEntity.setCreatedBy(answerDTO.getCreatedBy());
//        answerEntity.setCreatedOn(answerDTO.getCreatedOn());
//        answerEntity.setUpdatedOn(answerDTO.getUpdatedOn());
//        return answerEntity;
//    }

//    @Mapping(source="questionId", target="questionId")
//    @Mapping(source="answer", target="answer")
//    @Mapping(source="likes", target="likes")
//    @Mapping(source="createdBy", target="createdBy")
//    @Mapping(source="createdOn", target="createdOn")
//    @Mapping(source="updatedOn", target="updatedOn")
//    @Mapping(source="comments", target="comments")
    AnswerDTO entityToDTO(AnswerEntity answerEntity);
//    {
//        AnswerDTO answerDTO = new AnswerDTO();
//        answerDTO.setAnswer(answerEntity.getAnswer());
//        answerDTO.setCreatedBy(answerEntity.getCreatedBy());
//        answerDTO.setCreatedOn(answerEntity.getCreatedOn());
//        answerDTO.setUpdatedOn(answerEntity.getUpdatedOn());
//        return answerDTO;
//    }
}
