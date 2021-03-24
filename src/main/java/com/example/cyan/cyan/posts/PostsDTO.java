package com.example.cyan.cyan.posts;

import com.example.cyan.cyan.comments.CommentDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostsDTO implements Serializable {
    String postId;
    String content;
    String tags;
    Integer likes;
    String postType;
    String createdBy;
    LocalDateTime createdOn;
    LocalDateTime updatedOn;
    List<CommentDTO> comments;
}
