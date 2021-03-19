package com.example.cyan.cyan.answers;

import org.springframework.stereotype.Component;

@Component
public class AnswerMapper {
    public AnswerEntity dtoToEntity(AnswerDTO answerDTO){
        AnswerEntity answerEntity = new AnswerEntity();
        answerEntity.setAnswer(answerDTO.getAnswer());
        answerEntity.setCreatedBy(answerDTO.getCreatedBy());
        answerEntity.setCreatedOn(answerDTO.getCreatedOn());
        answerEntity.setUpdatedOn(answerDTO.getUpdatedOn());
        return answerEntity;
    }

    public AnswerDTO entityToDTO(AnswerEntity answerEntity){
        AnswerDTO answerDTO = new AnswerDTO();
        answerDTO.setAnswer(answerEntity.getAnswer());
        answerDTO.setCreatedBy(answerEntity.getCreatedBy());
        answerDTO.setCreatedOn(answerEntity.getCreatedOn());
        answerDTO.setUpdatedOn(answerEntity.getUpdatedOn());
        return answerDTO;
    }
}
