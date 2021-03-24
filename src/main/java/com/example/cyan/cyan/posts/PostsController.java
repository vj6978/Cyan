package com.example.cyan.cyan.posts;

import com.example.cyan.cyan.constants.ErrorConstants;
import com.example.cyan.cyan.exceptions.PostNotFoundException;
import com.example.cyan.cyan.exceptions.PostTypeNotSupportedException;
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
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private GenericPostServices genericPostServices;

    @Autowired
    private List<PostsService> postsServices;

    @GetMapping("/all/{createdBy}")
    public ResponseEntity<List<PostsDTO>> getAllPostsForAUser(@PathVariable String createdBy){
        return ResponseEntity.ok().body(genericPostServices.getAllPostsForAUser(createdBy));
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostsDTO> getPostById(@PathVariable String postId) throws PostNotFoundException {
        return ResponseEntity.ok().body(genericPostServices.getPostById(postId));
    }

    @GetMapping("/search/tag")
    public ResponseEntity<List<PostsDTO>> searchByTag(@RequestBody PostSearchDTO postSearchDTO){
        return ResponseEntity.ok().body(genericPostServices.getPostByTag(postSearchDTO.getTag()));
    }

    @GetMapping("/search/keyword")
    public ResponseEntity<List<PostsDTO>> searchByKeyword(@RequestBody PostSearchDTO postSearchDTO){
        return ResponseEntity.ok().body(genericPostServices.getPostByKeyword(postSearchDTO.getKeyword()));
    }

    @PostMapping("/new")
    public ResponseEntity<PostsDTO> postQuestion(@RequestBody PostsDTO postsDTO) throws PostTypeNotSupportedException {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                postsServices.stream()
                .filter(postsService -> postsService.accept(postsDTO))
                .findFirst()
                .orElseThrow(() -> new PostTypeNotSupportedException(ErrorConstants.POST_TYPE_NOT_SUPPORTED))
                .post(postsDTO));
    }

    @PutMapping("/post")
    public ResponseEntity<PostsDTO> putQuestion(@RequestBody PostsDTO postsDTO) throws PostNotFoundException {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(genericPostServices.put(postsDTO));
    }

    @PutMapping("/post/react")
    public ResponseEntity<PostsDTO> reactToPost(@RequestBody PostReactionDTO postReactionDTO) throws PostNotFoundException {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(genericPostServices.react(postReactionDTO));
    }

    @DeleteMapping("/post/{postId}")
    public ResponseEntity<PostsDTO> deletePostById(@PathVariable String postId) throws PostNotFoundException {
        genericPostServices.delete(postId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
