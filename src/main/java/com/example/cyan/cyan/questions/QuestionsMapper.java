package com.example.cyan.cyan.questions;

import org.springframework.stereotype.Component;

@Component
public class QuestionsMapper {
    public QuestionEntity dtoToEntity(QuestionDTO questionDTO){
        if(questionDTO == null){
            return null;
        }
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setId(questionDTO.getId());
        questionEntity.setQuestion(questionDTO.getQuestion());
        questionEntity.setTags(questionDTO.getTags());
        questionEntity.setComments(questionDTO.getComments());
        questionEntity.setAnswers(questionDTO.getAnswers());
        questionEntity.setCreatedBy(questionDTO.getCreatedBy());
        questionEntity.setCreatedOn(questionDTO.getCreatedOn());
        questionEntity.setUpdatedOn(questionDTO.getUpdatedOn());
        return questionEntity;
    }

    public QuestionDTO entityToDTO(QuestionEntity questionEntity){
        if(questionEntity == null){
            return null;
        }
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setId(questionEntity.getId());
        questionDTO.setQuestion(questionEntity.getQuestion());
        questionDTO.setTags(questionEntity.getTags());
        questionDTO.setComments(questionEntity.getComments());
        questionDTO.setAnswers(questionEntity.getAnswers());
        questionDTO.setCreatedBy(questionEntity.getCreatedBy());
        questionDTO.setCreatedOn(questionEntity.getCreatedOn());
        questionDTO.setUpdatedOn(questionEntity.getUpdatedOn());
        return questionDTO;
    }
}