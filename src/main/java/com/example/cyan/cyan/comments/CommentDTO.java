package com.example.cyan.cyan.comments;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CommentDTO {
    String id;
    String comment;
    String createdBy;
    Integer likes;
    LocalDateTime createdOn;
    LocalDateTime updatedOn;
}
