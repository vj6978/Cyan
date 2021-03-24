package com.example.cyan.cyan.posts;

import com.example.cyan.cyan.comments.CommentDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public abstract class PostsEntity {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    String postId;
    Integer likes;
    String tags;
    String postType;
    String createdBy;
    LocalDateTime createdOn;
    LocalDateTime updatedOn;
    @OneToMany(mappedBy="postsEntity", cascade= CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
    List<CommentDTO> comments;
}
