package com.pard.server.hw4.post.controller;

import com.pard.server.hw4.post.dto.PostRequestDto;
import com.pard.server.hw4.post.dto.PostResponseDto;
import com.pard.server.hw4.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @GetMapping("/author/{authorId}")
    public List<PostRequestDto> getPostsByAuthor(@PathVariable Long authorId) {
        return postService.getPostsByAuthor(authorId);
    }

    @PostMapping
    public PostResponseDto createPost(@RequestBody PostRequestDto dto) {
        return postService.createPost(dto);
    }

    @PutMapping("/{postId}")
    public PostRequestDto updatePost(@PathVariable Long postId, @RequestBody PostRequestDto dto) {
        return postService.updatePost(postId, dto);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId, @RequestParam Long authorId) {
        postService.deletePost(postId, authorId);
        return ResponseEntity.ok().build();
    }
}
