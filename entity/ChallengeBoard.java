package com.example.joinup.challengeboard.entity;

import com.example.joinup.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "challenge_board")
public class ChallengeBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "challenge_id")
    private Integer challengeId;

    @Column(name = "title", nullable = false, length = 100) // 제목
    private String title;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT") // 본문
    private String content;

    @Column(name = "created_at", nullable = false) // 작성 시간
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "views", nullable = false) // 조회수
    private Integer views = 0;
}
