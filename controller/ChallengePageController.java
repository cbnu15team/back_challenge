package com.example.joinup.challengeboard.controller;

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

    @GetMapping
    public List<ChallengePage> getAllPages() {
        return challengePageService.getAllPages();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePage(@PathVariable Integer id, @RequestBody ChallengePage updatedPage) {
        try {
            ChallengePage page = challengePageService.updatePage(id, updatedPage);
            return ResponseEntity.ok(page);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("페이지 수정 실패: " + e.getMessage());
        }
    }
}
