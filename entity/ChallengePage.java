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

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Transient
    private String title;

    @Transient
    private String author;

    @Transient
    private Integer views;
}
