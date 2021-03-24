package com.example.cyan.cyan.answers;

import com.example.cyan.cyan.comments.CommentDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AnswerDTO {
    String answerId;
    String questionId;
    String answer;
    Integer likes;
    String createdBy;
    LocalDateTime createdOn;
    LocalDateTime updatedOn;
    List<CommentDTO> comments;
}
