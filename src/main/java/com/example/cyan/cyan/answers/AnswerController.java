package com.example.cyan.cyan.answers;

import com.example.cyan.cyan.exceptions.QuestionNotFoundException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @GetMapping("/questionId")
    public ResponseEntity<List<AnswerDTO>> getAllAnswersForAQuestion(@PathVariable String questionId){
        return ResponseEntity.ok().body(answerService.getAllAnswersForAQuestion(questionId));
    }

    @PostMapping("/new")
    public ResponseEntity<AnswerDTO> postAnswer(@RequestBody AnswerDTO answerDTO){
        return ResponseEntity.ok().body(answerService.postAnswer(answerDTO));
    }

//    @PutMapping("/question")
//    public ResponseEntity<AnswerDTO> putAnswer(@RequestBody AnswerDTO answerDTO){
//
//    }
//
//    @DeleteMapping("/answer/{id}")
//    public ResponseEntity<AnswerDTO> deleteAnswer(@PathVariable String id){
//
//    }
}
