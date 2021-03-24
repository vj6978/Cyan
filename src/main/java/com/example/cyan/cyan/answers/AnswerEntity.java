package com.example.cyan.cyan.answers;

import com.example.cyan.cyan.comments.CommentEntity;
import com.example.cyan.cyan.questions.QuestionEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    String answerId;
    String questionId;
    String answer;
    Integer likes;
    String createdBy;
    LocalDateTime createdOn;
    LocalDateTime updatedOn;
    @OneToMany(mappedBy="answerEntity", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
    List<CommentEntity> comments;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="postId", nullable = false)
    QuestionEntity questionEntity;
}
