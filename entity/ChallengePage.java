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
    @JoinColumn(name = "challenge_id", nullable = false) 
    private ChallengeBoard challengeBoard;

    @Column(name = "created_at", nullable = false) // 작성 시간
    private LocalDateTime createdAt;

    @Transient    
    private String title;    // 제목 

    @Transient
    private String author;    // 작성자

    @Transient
    private Integer views;    // 조회수
}
