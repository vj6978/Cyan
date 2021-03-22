package com.example.cyan.cyan.answers;

import com.example.cyan.cyan.constants.ErrorConstants;
import com.example.cyan.cyan.exceptions.AnswerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    public List<AnswerDTO> getAllAnswersForAQuestion(String questionId){
        return answerRepository.findByQuestionId(questionId).stream()
                .map(AnswerMapper.INSTANCE::entityToDTO).collect(Collectors.toList());
    }

    public AnswerDTO postAnswer(AnswerDTO answerDTO){
        AnswerEntity answerEntity = AnswerMapper.INSTANCE.dtoToEntity(answerDTO);
        answerEntity.setQuestionId(answerDTO.getQuestionId());
        answerEntity.setLikes(0);
        answerEntity.setCreatedOn(LocalDateTime.now());
        answerEntity.setUpdatedOn(answerDTO.getCreatedOn());
        answerRepository.save(answerEntity);
        return AnswerMapper.INSTANCE.entityToDTO(answerEntity);
    }

    public AnswerDTO putAnswer(AnswerDTO answerDTO) throws AnswerNotFoundException {
        Optional<AnswerEntity> answer = answerRepository.findById(answerDTO.getId());
        if(answer.isEmpty()){
            throw new AnswerNotFoundException(ErrorConstants.NO_ANSWER_FOUND);
        }
        AnswerEntity answerEntity = answer.get();
        answerEntity.setId(answerDTO.getId());
        answerEntity.setAnswer(answerDTO.getAnswer());
        answerEntity.setComments(answerDTO.getComments());
        answerEntity.setLikes(answerDTO.getLikes());
        answerEntity.setQuestionId(answerDTO.getQuestionId());
        answerEntity.setCreatedBy(answerDTO.getCreatedBy());
        answerEntity.setCreatedOn(answerDTO.getCreatedOn());
        answerEntity.setUpdatedOn(answerDTO.getUpdatedOn());
        return AnswerMapper.INSTANCE.entityToDTO(answerRepository.save(answerEntity));
    }

    public AnswerDTO putAnswerLike(AnswerLikeUpdateDTO answerLikeUpdateDTO) throws AnswerNotFoundException {
        Optional<AnswerEntity> answer = answerRepository.findById(answerLikeUpdateDTO.getAnswerId());
        if(answer.isEmpty()){
            throw new AnswerNotFoundException(ErrorConstants.NO_ANSWER_FOUND);
        }
        AnswerEntity answerEntity = answer.get();
        answerEntity.setId(answerLikeUpdateDTO.getAnswerId());
        answerEntity.setLikes(answerEntity.getLikes() + answerLikeUpdateDTO.getLikeUpdateValue());
        return AnswerMapper.INSTANCE.entityToDTO(answerRepository.save(answerEntity));
    }

    public void deleteAnswer(String id) throws AnswerNotFoundException {
        Optional<AnswerEntity> answer = answerRepository.findById(id);
        if(answer.isEmpty()){
            throw new AnswerNotFoundException(ErrorConstants.NO_ANSWER_FOUND);
        }
        answerRepository.delete(answer.get());
    }
}
