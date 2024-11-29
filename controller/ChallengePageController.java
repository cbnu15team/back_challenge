package com.example.joinup.challengeboard.controller;

import com.example.joinup.challengeboard.entity.ChallengeBoard;
import com.example.joinup.challengeboard.entity.ChallengePage;
import com.example.joinup.challengeboard.service.ChallengePageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/challenge-pages")
public class ChallengePageController {

    private final ChallengePageService challengePageService;

    public ChallengePageController(ChallengePageService challengePageService) {
        this.challengePageService = challengePageService;
    }

    // 모든 ChallengePage 목록 조회
    @GetMapping
    public ResponseEntity<List<ChallengePage>> getAllPages() {
        try {
            List<ChallengePage> pages = challengePageService.getAllPages();

            // ChallengeBoard 데이터를 설정
            pages.forEach(page -> {
                ChallengeBoard board = page.getChallengeBoard();
                page.setTitle(board.getTitle());
                page.setAuthor(board.getUser().getId()); // 작성자(User ID)
                page.setViews(board.getViews());
            });

            return ResponseEntity.ok(pages);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    // ChallengePage 생성
    @PostMapping
    public ResponseEntity<?> createPage(@RequestBody ChallengePage page) {
        try {
            ChallengePage createdPage = challengePageService.createPage(page);
            ChallengeBoard board = createdPage.getChallengeBoard();
            createdPage.setTitle(board.getTitle());
            createdPage.setAuthor(board.getUser().getId());
            createdPage.setViews(board.getViews());
            return ResponseEntity.ok(createdPage);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("ChallengePage 생성 실패: " + e.getMessage());
        }
    }

    // 특정 ChallengePage 조회
    @GetMapping("/{id}")
    public ResponseEntity<?> getPageById(@PathVariable Integer id) {
        try {
            ChallengePage page = challengePageService.getPageById(id);
            ChallengeBoard board = page.getChallengeBoard();
            page.setTitle(board.getTitle());
            page.setAuthor(board.getUser().getId());
            page.setViews(board.getViews());
            return ResponseEntity.ok(page);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("ChallengePage 조회 실패: " + e.getMessage());
        }
    }

    // ChallengePage 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePageById(@PathVariable Integer id) {
        try {
            challengePageService.deletePageById(id);
            return ResponseEntity.ok("ChallengePage가 성공적으로 삭제되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("ChallengePage 삭제 실패: " + e.getMessage());
        }
    }
}
