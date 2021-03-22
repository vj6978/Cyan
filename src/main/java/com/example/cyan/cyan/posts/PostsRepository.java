package com.example.cyan.cyan.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<PostsEntity, String> {
    List<PostsEntity> findByCreatedBy(String createdBy);
}
