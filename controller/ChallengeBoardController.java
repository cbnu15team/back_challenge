package com.example.joinup.challengeboard.controller;

import com.example.joinup.challengeboard.entity.ChallengeBoard;
import com.example.joinup.challengeboard.service.ChallengeBoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/challenge-boards")
public class ChallengeBoardController {

    private final ChallengeBoardService challengeBoardService;

    public ChallengeBoardController(ChallengeBoardService challengeBoardService) {
        this.challengeBoardService = challengeBoardService;
    }

    // 모든 게시글 조회
    @GetMapping
    public List<ChallengeBoard> getAllBoards() {
        return challengeBoardService.getAllBoards();
    }

    // 특정 게시글 조회
    @GetMapping("/{id}")
    public ResponseEntity<?> getBoardById(@PathVariable Integer id) {
        try {
            ChallengeBoard board = challengeBoardService.getBoardById(id);
            return ResponseEntity.ok(board);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 게시글 생성
    @PostMapping
    public ResponseEntity<?> createBoard(@RequestBody ChallengeBoard board) {
        try {
            ChallengeBoard createdBoard = challengeBoardService.createBoard(board);
            return ResponseEntity.ok(createdBoard);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("게시글 생성 실패: " + e.getMessage());
        }
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBoardById(@PathVariable Integer id) {
        try {
            challengeBoardService.deleteBoardById(id);
            return ResponseEntity.ok("게시글이 성공적으로 삭제되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("게시글 삭제 실패: " + e.getMessage());
        }
    }
}
