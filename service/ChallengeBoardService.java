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

    public List<ChallengeBoard> getAllBoards() {
        return challengeBoardRepository.findAll();
    }

    public ChallengeBoard getBoardById(Integer id) {
        return challengeBoardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 ID의 게시글을 찾을 수 없습니다. ID: " + id));
    }

    public ChallengeBoard createBoard(ChallengeBoard board) {
        board.setCreatedAt(LocalDateTime.now());
        board.setViews(0);
        return challengeBoardRepository.save(board);
    }

    public ChallengeBoard updateBoard(Integer id, ChallengeBoard updatedBoard) {
        ChallengeBoard existingBoard = challengeBoardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 ID의 게시글을 찾을 수 없습니다. ID: " + id));

        existingBoard.setTitle(updatedBoard.getTitle());
        existingBoard.setContent(updatedBoard.getContent());
        return challengeBoardRepository.save(existingBoard);
    }

    public void deleteBoardById(Integer id) {
        challengeBoardRepository.deleteById(id);
    }
}
