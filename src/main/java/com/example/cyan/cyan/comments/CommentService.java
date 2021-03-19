package com.example.cyan.cyan.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentMapper commentMapper;

    public List<CommentDTO> getAllComments(){
        return commentRepository.findAll().stream()
                .map(c->commentMapper.entityToDTO(c)).collect(Collectors.toList());
    }
}
