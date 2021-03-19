package com.example.cyan.cyan.questions;

import org.springframework.stereotype.Component;

@Component
public class QuestionsMapper {
    public QuestionEntity dtoToEntity(QuestionDTO questionDTO){
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setQuestion(questionDTO.getQuestion());
        questionEntity.setTags(questionDTO.getTags());
        questionEntity.setCreatedBy(questionDTO.getCreatedBy());
        questionEntity.setCreatedOn(questionDTO.getCreatedOn());
        questionEntity.setUpdatedOn(questionDTO.getUpdatedOn());
        return questionEntity;
    }

    public QuestionDTO entityToDTO(QuestionEntity questionEntity){
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setId(questionEntity.getId());
        questionDTO.setQuestion(questionEntity.getQuestion());
        questionDTO.setTags(questionEntity.getTags());
        questionDTO.setCreatedBy(questionEntity.getCreatedBy());
        questionDTO.setCreatedOn(questionEntity.getCreatedOn());
        questionDTO.setUpdatedOn(questionEntity.getUpdatedOn());
        return questionDTO;
    }
}