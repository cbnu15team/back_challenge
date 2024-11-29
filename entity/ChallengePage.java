package com.example.joinup.challengeboard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "challenge_page")
public class ChallengePage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "page_id")
    private Integer pageId;

    @ManyToOne
    @JoinColumn(name = "challenge_id", nullable = false) // ChallengeBoard와 연관
    private ChallengeBoard challengeBoard;

    @Column(name = "created_at", nullable = false) // ChallengePage 생성 시간
    private LocalDateTime createdAt;

    @Transient // DB에 저장하지 않고 ChallengeBoard의 데이터를 가져옴
    private String title;

    @Transient
    private String author;

    @Transient
    private Integer views;
}
