package com.example.cyan.cyan.questions;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QuestionJPAHelperSpecification {
    public static Specification<QuestionEntity> containsTag(String tag){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.upper(root.get("tags")),
                "%"+tag.toUpperCase()+"%");
    }

    public static Specification<QuestionEntity> containskeywordInQuestion(String keyword){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.upper(root.get("question")),
                "%"+keyword.toUpperCase()+"%");
    }
}
