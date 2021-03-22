package com.example.cyan.cyan.questions;

import com.example.cyan.cyan.comments.CommentEntity;
import com.example.cyan.cyan.constants.ErrorConstants;
import com.example.cyan.cyan.exceptions.QuestionNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    private static final Logger logger = LoggerFactory.getLogger(QuestionService.class);

    public List<QuestionDTO> getAll(){
        return questionRepository.findAll().stream().map(QuestionsMapper.INSTANCE::entityToDTO).collect(Collectors.toList());
    }

    public QuestionDTO getQuestion(String id) throws QuestionNotFoundException {
        Optional<QuestionEntity> question = questionRepository.findById(id);
        if(question.isPresent()){
            return QuestionsMapper.INSTANCE.entityToDTO(question.get());
        }
        throw new QuestionNotFoundException(ErrorConstants.NO_QUESTION_FOUND);
    }

    public List<QuestionDTO> getAllQuestionsForAUser(String createdBy){
        return questionRepository.findByCreatedBy(createdBy).stream()
                .map(QuestionsMapper.INSTANCE::entityToDTO).collect(Collectors.toList());
    }

    public List<QuestionDTO> getQuestionByTag(String tag){
        return questionRepository.findAll(QuestionJPAHelperSpecification.containsTag(tag))
                .stream().map(QuestionsMapper.INSTANCE::entityToDTO).collect(Collectors.toList());
    }

    public List<QuestionDTO> getQuestionByKeyword(String keyword){
        return questionRepository.findAll(QuestionJPAHelperSpecification.containskeywordInQuestion(keyword))
                .stream().map(QuestionsMapper.INSTANCE::entityToDTO).collect(Collectors.toList());
    }

    public QuestionDTO postQuestion(QuestionDTO questionDTO){
        questionDTO.setCreatedOn(LocalDateTime.now());
        questionDTO.setUpdatedOn(questionDTO.getCreatedOn());
        QuestionEntity questionEntity = QuestionsMapper.INSTANCE.dtoToEntity(questionDTO);
        return QuestionsMapper.INSTANCE.entityToDTO(questionRepository.save(questionEntity));
    }

    public QuestionDTO putQuestion(QuestionDTO questionDTO) throws QuestionNotFoundException {
       Optional<QuestionEntity> question = questionRepository.findById(questionDTO.getId());
       if(question.isEmpty()){
           throw new QuestionNotFoundException(ErrorConstants.NO_QUESTION_FOUND);
       }
       QuestionEntity questionEntity = question.get();
       questionEntity.setId(questionDTO.getId());
       questionEntity.setQuestion(questionDTO.getQuestion());
       questionEntity.setTags(questionDTO.getTags());
       questionEntity.setCreatedBy(questionDTO.getCreatedBy());
       questionEntity.setCreatedOn(questionDTO.getCreatedOn());
       questionEntity.setUpdatedOn(LocalDateTime.now());
       if(questionDTO.getComments() != null){
           questionEntity.setComments(questionDTO.getComments());
       }
       return QuestionsMapper.INSTANCE.entityToDTO(questionRepository.save(questionEntity));
    }

    public void deleteQuestion(String id) throws QuestionNotFoundException {
        Optional<QuestionEntity> question = questionRepository.findById(id);
        if(question.isEmpty()){
            throw new QuestionNotFoundException(ErrorConstants.NO_QUESTION_FOUND);
        }
        questionRepository.delete(question.get());

    }
}
