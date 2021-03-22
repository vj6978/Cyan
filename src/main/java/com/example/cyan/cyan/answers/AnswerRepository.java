package com.example.cyan.cyan.answers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<AnswerEntity, String> {
    List<AnswerEntity> findByQuestionId(String questionId);
}
