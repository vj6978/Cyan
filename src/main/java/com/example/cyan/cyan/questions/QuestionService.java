package com.example.cyan.cyan.questions;

import com.example.cyan.cyan.constants.ErrorConstants;
import com.example.cyan.cyan.exceptions.QuestionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionsMapper questionsMapper;

    public List<QuestionDTO> getAll(){
        return questionRepository.findAll().stream().map(q -> questionsMapper.entityToDTO(q)).collect(Collectors.toList());
    }

    public QuestionDTO getQuestion(String id) throws QuestionNotFoundException {
        Optional<QuestionEntity> question = questionRepository.findById(id);
        if(question.isPresent()){
            return questionsMapper.entityToDTO(question.get());
        }
        throw new QuestionNotFoundException(ErrorConstants.NO_QUESTION_FOUND);
    }

    public List<QuestionDTO> getQuestionByTag(String tag){
        return questionRepository.findAll(QuestionJPAHelperSpecification.containsTag(tag))
                .stream().map(q -> questionsMapper.entityToDTO(q)).collect(Collectors.toList());
    }

    public List<QuestionDTO> getQuestionByKeyword(String keyword){
        return questionRepository.findAll(QuestionJPAHelperSpecification.containskeywordInQuestion(keyword))
                .stream().map(q -> questionsMapper.entityToDTO(q)).collect(Collectors.toList());
    }

    public QuestionDTO postQuestion(QuestionDTO questionDTO){
        questionDTO.setCreatedOn(LocalDateTime.now());
        questionDTO.setUpdatedOn(questionDTO.getCreatedOn());
        QuestionEntity questionEntity = questionsMapper.dtoToEntity(questionDTO);
        return questionsMapper.entityToDTO(questionRepository.save(questionEntity));
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
       return questionsMapper.entityToDTO(questionRepository.save(questionEntity));
    }

    public void deleteQuestion(String id) throws QuestionNotFoundException {
        Optional<QuestionEntity> question = questionRepository.findById(id);
        if(question.isPresent()){
            questionRepository.delete(question.get());
        }
        else
            throw new QuestionNotFoundException(ErrorConstants.NO_QUESTION_FOUND);
    }
}
