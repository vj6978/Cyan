package com.example.cyan.cyan.answers;

import com.example.cyan.cyan.exceptions.QuestionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    public AnswerDTO postAnswer(AnswerDTO answerDTO) throws QuestionNotFoundException {
        //Set Answer properties.
        AnswerEntity answerEntity = AnswerMapper.INSTANCE.dtoToEntity(answerDTO);
        answerEntity.setQuestionId(answerDTO.getQuestionId());
        answerEntity.setLikes(0);
        answerEntity.setCreatedOn(LocalDateTime.now());
        answerEntity.setUpdatedOn(answerDTO.getCreatedOn());
        answerRepository.save(answerEntity);
        return answerDTO;
    }
}
