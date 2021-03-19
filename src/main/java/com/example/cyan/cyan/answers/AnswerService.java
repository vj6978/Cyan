package com.example.cyan.cyan.answers;

import com.example.cyan.cyan.exceptions.QuestionNotFoundException;
import com.example.cyan.cyan.questions.QuestionEntity;
import com.example.cyan.cyan.questions.QuestionService;
import com.example.cyan.cyan.questions.QuestionsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private AnswerMapper answerMapper;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuestionsMapper questionsMapper;

    public AnswerDTO postAnswer(AnswerDTO answerDTO) throws QuestionNotFoundException {
        List<AnswerEntity> answerList = new ArrayList<>();
        //Get question to which answer should be added
        QuestionEntity question = questionsMapper.dtoToEntity(questionService.getQuestion(answerDTO.getQuestionId()));
        //Set Answer properties.
        AnswerEntity answer = answerMapper.dtoToEntity(answerDTO);
        answer.setLikes(0);
        answer.setCreatedOn(LocalDateTime.now());
        answer.setUpdatedOn(answer.getCreatedOn());
        //Add answer to list of answers under question
        if(question.getAnswers() == null){
            answerList.add(answer);
            question.setAnswers(answerList);
        }
        else {
            question.getAnswers().add(answer);
        }
        //Update question with answer back to db
        questionService.putQuestion(questionsMapper.entityToDTO(question));
        return answerDTO;
    }
}
