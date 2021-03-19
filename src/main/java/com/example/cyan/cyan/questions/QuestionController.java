package com.example.cyan.cyan.questions;

import com.example.cyan.cyan.exceptions.QuestionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/all")
    public ResponseEntity<List<QuestionDTO>> getAllQuestions(){
        return ResponseEntity.ok().body(questionService.getAll());
    }

    @GetMapping("/question/{id}")
    public ResponseEntity<QuestionDTO> getQuestion(@PathVariable String id) throws QuestionNotFoundException {
        return ResponseEntity.ok().body(questionService.getQuestion(id));
    }

    @PostMapping("/question")
    public ResponseEntity<QuestionDTO> postQuestion(@RequestBody QuestionDTO questionDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(questionService.postQuestion(questionDTO));
    }

    @PutMapping("/question")
    public ResponseEntity<QuestionDTO> putQuestion(@RequestBody QuestionDTO questionDTO) throws QuestionNotFoundException {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(questionService.putQuestion(questionDTO));
    }

    @DeleteMapping("/question/{id}")
    public ResponseEntity<QuestionDTO> deleteQuestion(@PathVariable String id) throws QuestionNotFoundException {
        questionService.deleteQuestion(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
