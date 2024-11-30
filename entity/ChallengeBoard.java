package com.example.joinup.challengeboard.entity;

import com.example.joinup.challengeboard.entity.ChallengePage;
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
    @Column(name = "board_id")
    private Long boardId;

    @OneToOne
    @JoinColumn(name = "page_id", nullable = false) // ChallengePage와 연결
    private ChallengePage challengePage;

    @Transient // ChallengePage 정보를 참조해서 값을 가져옴
    private String title;

    @Transient
    private String nickname;

    @Transient
    private LocalDateTime createdAt;

    @Transient
    private int views;

    @PostLoad
    public void loadFromChallengePage() {
        if (challengePage != null) {
            this.title = challengePage.getTitle();
            this.nickname = challengePage.getNickname();
            this.createdAt = challengePage.getCreatedAt();
            this.views = challengePage.getViews();
        }
    }
}
