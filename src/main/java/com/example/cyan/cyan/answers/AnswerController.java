package com.example.cyan.cyan.answers;

import com.example.cyan.cyan.exceptions.QuestionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/answers")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @PostMapping("/new")
    public ResponseEntity<AnswerDTO> postAnswer(@RequestBody AnswerDTO answerDTO) throws QuestionNotFoundException {
        return ResponseEntity.ok().body(answerService.postAnswer(answerDTO));
    }
}
