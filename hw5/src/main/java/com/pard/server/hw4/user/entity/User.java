package com.pard.server.hw4.user.entity;

import com.pard.server.hw4.post.entity.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @OneToMany(mappedBy = "author")
    private List<Post> posts;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING) //이거 안하면 숫자로 들어감
    @Builder.Default
    private Role role = Role.USER;

    private String socialId;

}
