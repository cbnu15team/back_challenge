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

    // 모든 ChallengePage 조회
    public List<ChallengePage> getAllPages() {
        return challengePageRepository.findAll();
    }

    // ChallengePage 생성
    public ChallengePage createPage(ChallengePage page) {
        return challengePageRepository.save(page);
    }

    // 특정 ChallengePage 조회
    public ChallengePage getPageById(Integer id) {
        return challengePageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ChallengePage를 찾을 수 없습니다. ID: " + id));
    }

    // ChallengePage 삭제
    public void deletePageById(Integer id) {
        ChallengePage page = challengePageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ChallengePage를 찾을 수 없습니다. ID: " + id));
        challengePageRepository.delete(page);
    }
}
