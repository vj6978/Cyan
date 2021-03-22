package com.example.cyan.cyan.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<CommentDTO> getAllComments(){
        return commentRepository.findAll().stream()
                .map(CommentMapper.INSTANCE::entityToDTO).collect(Collectors.toList());
    }
}
