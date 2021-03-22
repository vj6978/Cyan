package com.example.cyan.cyan.answers;

import com.example.cyan.cyan.comments.CommentEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AnswerDTO {
    String questionId;
    String answer;
    Integer likes;
    String createdBy;
    LocalDateTime createdOn;
    LocalDateTime updatedOn;
    List<CommentEntity> comments;
}
