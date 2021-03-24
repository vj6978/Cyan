package com.example.cyan.cyan.questions;

import com.example.cyan.cyan.answers.AnswerDTO;
import com.example.cyan.cyan.posts.PostsEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class QuestionEntity extends PostsEntity {
    String question;
    @OneToMany(mappedBy="answer", cascade= CascadeType.ALL, orphanRemoval=true, fetch= FetchType.EAGER)
    List<AnswerDTO> answers;
}
