package com.example.cyan.cyan.questions;

import com.example.cyan.cyan.answers.AnswerEntity;
import com.example.cyan.cyan.comments.CommentEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="QUESTION_TBL")
@NoArgsConstructor
public class QuestionEntity {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    String id;
    String question;
    String tags;
    String createdBy;
    LocalDateTime createdOn;
    LocalDateTime updatedOn;
    @OneToMany(mappedBy="id", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
    List<CommentEntity> comments;
    @OneToMany(mappedBy="id", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
    List<AnswerEntity> answers;
}
