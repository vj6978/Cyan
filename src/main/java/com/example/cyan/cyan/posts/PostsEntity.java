package com.example.cyan.cyan.posts;

import com.example.cyan.cyan.answers.AnswerEntity;
import com.example.cyan.cyan.comments.CommentEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostsEntity implements Serializable {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    String postId;
    String content;
    Integer likes;
    String tags;
    String postType;
    String createdBy;
    LocalDateTime createdOn;
    LocalDateTime updatedOn;
    @OneToMany(mappedBy="postsEntity", cascade= CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
    List<CommentEntity> comments;
    @OneToMany(mappedBy="postsEntity", cascade= CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
    List<AnswerEntity> answers;
}
