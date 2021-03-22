package com.example.cyan.cyan.posts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PostsDTO {
    String postId;
    String tags;
    Integer likes;
    String content;
    String postType;
    String createdBy;
    LocalDateTime createdOn;
    LocalDateTime updatedOn;
}
