package com.example.cyan.cyan.exceptions;

import com.example.cyan.cyan.constants.ErrorConstants;
import com.example.cyan.cyan.exceptions.error.APIError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value={QuestionNotFoundException.class})
    public ResponseEntity<APIError> handleQuestionNotFound(){
        APIError error = new APIError(HttpStatus.NOT_FOUND, ErrorConstants.NO_QUESTION_FOUND);
        return ResponseEntity.badRequest().body(error);
    }
    @ExceptionHandler(value={AnswerNotFoundException.class})
    public ResponseEntity<APIError> handleAnswerNotFound(){
        APIError error = new APIError(HttpStatus.NOT_FOUND, ErrorConstants.NO_ANSWER_FOUND);
        return ResponseEntity.badRequest().body(error);
    }
}
