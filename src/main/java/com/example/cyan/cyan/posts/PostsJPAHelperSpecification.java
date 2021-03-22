package com.example.cyan.cyan.posts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostsJPAHelperSpecification {
    public static Specification<PostsEntity> containsTag(String tag){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.upper(root.get("tags")),
                "%"+tag.toUpperCase()+"%");
    }

    public static Specification<PostsEntity> containsKeywordInQuestion(String keyword){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.upper(root.get("question")),
                "%"+keyword.toUpperCase()+"%");
    }
}
