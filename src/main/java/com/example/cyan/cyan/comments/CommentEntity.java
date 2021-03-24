package com.example.cyan.cyan.comments;

import com.example.cyan.cyan.answers.AnswerEntity;
import com.example.cyan.cyan.posts.PostsEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="COMMENT_TBL")
@NoArgsConstructor
public class CommentEntity implements Serializable {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    String commentId;
    String postId;
    String comment;
    Integer likes;
    String createdBy;
    LocalDateTime createdOn;
    LocalDateTime updatedOn;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="answerId", nullable = false)
    AnswerEntity answerEntity;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="postId", nullable = false)
    PostsEntity postsEntity;
}
