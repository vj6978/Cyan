package com.example.cyan.cyan.answers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questions")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

}
