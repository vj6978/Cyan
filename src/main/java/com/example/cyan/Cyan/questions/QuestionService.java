package com.example.cyan.Cyan.questions;

import com.example.cyan.Cyan.constants.ErrorConstants;
import com.example.cyan.Cyan.exceptions.QuestionNotFoundException;
import com.example.cyan.Cyan.mapper.QuestionsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public QuestionDTO postQuestion(QuestionDTO questionDTO){
        QuestionEntity questionEntity = questionsMapper.dtoToEntity(questionDTO);
        return questionsMapper.entityToDTO(questionRepository.save(questionEntity));
    }

    public QuestionDTO putQuestion(QuestionDTO questionDTO) throws QuestionNotFoundException {
        QuestionEntity questionEntity = questionsMapper.dtoToEntity(questionDTO);
        Optional<QuestionEntity> question = questionRepository.findById(questionEntity.getId());
        if(question.isPresent()){
            question.get().setId(questionDTO.getId());
            question.get().setQuestion(questionDTO.getQuestion());
            question.get().setTags(questionDTO.getTags());
            question.get().setCreatedBy(questionDTO.getCreatedBy());
            question.get().setCreatedOn(question.get().getCreatedOn());
            return questionsMapper.entityToDTO(questionRepository.save(question.get()));
        }
        throw new QuestionNotFoundException(ErrorConstants.NO_QUESTION_FOUND);
    }

    public void deleteQuestion(String id) throws QuestionNotFoundException {
        Optional<QuestionEntity> question = questionRepository.findById(id);
        if(question.isPresent()){
            questionRepository.delete(question.get());
        }
        throw new QuestionNotFoundException(ErrorConstants.NO_QUESTION_FOUND);
    }
}
