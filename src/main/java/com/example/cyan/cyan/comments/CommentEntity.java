package com.example.cyan.cyan.comments;

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
@Table(name="COMMENT_TBL")
@NoArgsConstructor
public class CommentEntity {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    String id;
    String postId;
    String comment;
    Integer likes;
    String createdBy;
    LocalDateTime createdOn;
    LocalDateTime updatedOn;
}
