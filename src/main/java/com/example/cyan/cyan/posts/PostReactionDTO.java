package com.example.cyan.cyan.posts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostReactionDTO {
    String postId;
    Integer reactionScore;
}
