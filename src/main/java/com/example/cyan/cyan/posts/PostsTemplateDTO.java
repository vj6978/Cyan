package com.example.cyan.cyan.posts;

import com.example.cyan.cyan.answers.AnswerDTO;
import com.example.cyan.cyan.comments.CommentDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostsTemplateDTO {
    PostsDTO post;
    List<AnswerDTO> answers;
    List<CommentDTO> commentDTO;
}
