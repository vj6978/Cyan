package com.example.cyan.cyan.comments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, String> {
    List<CommentEntity> findByPostId(String postId);
}
