package com.example.cyan.cyan.comments;

import com.example.cyan.cyan.answers.AnswerDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CommentDTO {
    String commentId;
    String postId;
    String comment;
    Integer likes;
    String createdBy;
    LocalDateTime createdOn;
    LocalDateTime updatedOn;
    List<AnswerDTO> answers;
}
