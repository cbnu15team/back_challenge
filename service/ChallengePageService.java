package com.example.joinup.challengeboard.service;

import com.example.joinup.challengeboard.entity.ChallengePage;
import com.example.joinup.challengeboard.repository.ChallengePageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengePageService {

    private final ChallengePageRepository challengePageRepository;

    public ChallengePageService(ChallengePageRepository challengePageRepository) {
        this.challengePageRepository = challengePageRepository;
    }

    public List<ChallengePage> getAllPages() {
        return challengePageRepository.findAll();
    }

    public ChallengePage updatePage(Integer id, ChallengePage updatedPage) {
        ChallengePage existingPage = challengePageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 ID의 페이지를 찾을 수 없습니다. ID: " + id));

        existingPage.setCreatedAt(updatedPage.getCreatedAt());
        return challengePageRepository.save(existingPage);
    }
}
