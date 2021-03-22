package com.example.cyan.cyan.answers;

import com.example.cyan.cyan.exceptions.AnswerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/answer/{questionId}")
    public ResponseEntity<List<AnswerDTO>> getAllAnswersForAQuestion(@PathVariable String questionId){
        return ResponseEntity.ok().body(answerService.getAllAnswersForAQuestion(questionId));
    }

    @PostMapping("/new")
    public ResponseEntity<AnswerDTO> postAnswer(@RequestBody AnswerDTO answerDTO){
        return ResponseEntity.ok().body(answerService.postAnswer(answerDTO));
    }

    @PutMapping("/answer")
    public ResponseEntity<AnswerDTO> putAnswer(@RequestBody AnswerUpdateDTO answerUpdateDTO) throws AnswerNotFoundException {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(answerService.putAnswer(answerUpdateDTO));
    }

    @PutMapping("/answer/like")
    public ResponseEntity<AnswerDTO> putAnswerLike(@RequestBody AnswerUpdateDTO answerUpdateDTO) throws AnswerNotFoundException {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(answerService.putAnswerLike(answerUpdateDTO));
    }

    @DeleteMapping("/answer/{id}")
    public ResponseEntity<AnswerDTO> deleteAnswer(@PathVariable String id) throws AnswerNotFoundException {
        answerService.deleteAnswer(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
