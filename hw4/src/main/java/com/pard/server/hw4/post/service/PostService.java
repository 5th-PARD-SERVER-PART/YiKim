package com.pard.server.hw4.post.service;

import com.pard.server.hw4.post.dto.PostRequestDto;
import com.pard.server.hw4.post.dto.PostResponseDto;
import com.pard.server.hw4.post.entity.Post;
import com.pard.server.hw4.post.repository.PostRepository;
import com.pard.server.hw4.user.entity.User;
import com.pard.server.hw4.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public List<PostRequestDto> getPostsByAuthor(Long authorId) {
        return postRepository.findByAuthorId(authorId).stream()
                .map(post -> new PostRequestDto(post.getId(), post.getTitle(), post.getContent(), post.getAuthor().getId()))
                .collect(Collectors.toList());
    }

    public PostResponseDto createPost(PostRequestDto dto) {
        User author = userRepository.findById(dto.getAuthorId())
                .orElseThrow(() -> new IllegalArgumentException("작가가 존재하지 않습니다."));
        Post post = Post.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .author(author)
                .build();
        Post saved = postRepository.save(post);
        return new PostResponseDto(saved.getId(), saved.getTitle(), saved.getContent(), saved.getAuthor().getId(), saved.getAuthor().getUsername());
    }

    public PostRequestDto updatePost(Long postId, PostRequestDto dto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        if (!post.getAuthor().getId().equals(dto.getAuthorId())) {
            throw new IllegalArgumentException("작가만 게시글을 올릴 수 있습니다.");
        }
        post = Post.builder()
                .id(post.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .author(post.getAuthor())
                .build();
        Post updated = postRepository.save(post);
        return new PostRequestDto(updated.getId(), updated.getTitle(), updated.getContent(), updated.getAuthor().getId());
    }

    public void deletePost(Long postId, Long authorId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        if (!post.getAuthor().getId().equals(authorId)) {
            throw new IllegalArgumentException("작가만 게시글을 올릴 수 있습니다.");
        }
        postRepository.delete(post);
    }
}
