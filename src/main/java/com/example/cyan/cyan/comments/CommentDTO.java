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
    Integer likes;
    String createdBy;
    LocalDateTime createdOn;
    LocalDateTime updatedOn;
}
