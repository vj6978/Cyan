package com.example.cyan.cyan.answers;

import com.example.cyan.cyan.comments.CommentEntity;
import com.example.cyan.cyan.questions.QuestionEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="ANSWER_TBL")
public class AnswerEntity {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    String id;
    String answer;
    String createdBy;
    Integer likes;
    LocalDateTime createdOn;
    LocalDateTime updatedOn;
    @OneToMany(mappedBy="id", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
    List<CommentEntity> comments;
    @ManyToOne(fetch=FetchType.LAZY)
    QuestionEntity questionEntity;
}
