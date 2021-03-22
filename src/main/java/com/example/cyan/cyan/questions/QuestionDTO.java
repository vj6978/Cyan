package com.example.cyan.cyan.questions;

import com.example.cyan.cyan.comments.CommentEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class QuestionDTO {
    String id;
    String question;
    String tags;
    String createdBy;
    LocalDateTime createdOn;
    LocalDateTime updatedOn;
    List<CommentEntity> comments;
}
