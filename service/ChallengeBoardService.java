package com.example.joinup.challengeboard.service;

import com.example.joinup.challengeboard.entity.ChallengeBoard;
import com.example.joinup.challengeboard.repository.ChallengeBoardRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChallengeBoardService {

    private final ChallengeBoardRepository challengeBoardRepository;

    public ChallengeBoardService(ChallengeBoardRepository challengeBoardRepository) {
        this.challengeBoardRepository = challengeBoardRepository;
    }

    // 모든 게시글 조회
    public List<ChallengeBoard> getAllBoards() {
        return challengeBoardRepository.findAll();
    }

    // 특정 게시글 조회
    public ChallengeBoard getBoardById(Integer id) {
        return challengeBoardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다. ID: " + id));
    }

    // 게시글 생성
    public ChallengeBoard createBoard(ChallengeBoard board) {
        board.setCreatedAt(LocalDateTime.now());
        board.setViews(0); // 조회수 초기화
        return challengeBoardRepository.save(board);
    }

    // 게시글 삭제
    public void deleteBoardById(Integer id) {
        challengeBoardRepository.deleteById(id);
    }
}
