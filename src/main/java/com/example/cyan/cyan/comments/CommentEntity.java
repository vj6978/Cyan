package com.example.cyan.cyan.comments;

import com.example.cyan.cyan.answers.AnswerEntity;
import com.example.cyan.cyan.questions.QuestionEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="COMMENT_TBL")
@NoArgsConstructor
public class CommentEntity {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    String id;
    String comment;
    String createdBy;
    Integer likes;
    LocalDateTime createdOn;
    LocalDateTime updatedOn;
    @ManyToOne
    QuestionEntity questionEntity;
    @ManyToOne
    AnswerEntity answerEntity;
}
