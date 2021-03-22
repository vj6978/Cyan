package com.example.cyan.cyan.comments;

import com.example.cyan.cyan.exceptions.CommentNoFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController{
    @Autowired
    private CommentService commentService;

    @GetMapping("/comment/{postId}")
    public ResponseEntity<List<CommentDTO>> getAllCommentsOnAPost(@PathVariable String postId){
        return ResponseEntity.ok().body(commentService.getAllCommentsOnAPost(postId));
    }

    @PostMapping("/new")
    public ResponseEntity<CommentDTO> postComment(@RequestBody CommentDTO commentDTO){
        return ResponseEntity.ok().body(commentService.postComment(commentDTO));
    }

    @PutMapping("/comment")
    public ResponseEntity<CommentDTO> putComment(@RequestBody CommentDTO commentDTO) throws CommentNoFoundException {
        return ResponseEntity.ok().body(commentService.putComment(commentDTO));
    }

    @DeleteMapping("/comment/{id}")
    public ResponseEntity<List<CommentDTO>> deleteCommentOnPost(@PathVariable String id) throws CommentNoFoundException {
        commentService.deleteComment(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}