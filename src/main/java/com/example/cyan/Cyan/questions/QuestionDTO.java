package com.example.cyan.Cyan.questions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class QuestionDTO {
    String id;
    String question;
    String tags;
    String createdBy;
    LocalDateTime createdOn;
}
