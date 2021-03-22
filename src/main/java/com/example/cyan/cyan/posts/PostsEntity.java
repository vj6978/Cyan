package com.example.cyan.cyan.posts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="POSTS_TBL")
@NoArgsConstructor
public class PostsEntity {
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
}
