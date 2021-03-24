package com.example.cyan.cyan.answers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AnswerUpdateDTO {
    String answerId;
    String answer;
    Integer likeUpdateValue;
}
