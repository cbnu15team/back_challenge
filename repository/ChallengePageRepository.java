package com.example.joinup.challengeboard.repository;

import com.example.joinup.challengeboard.entity.ChallengePage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengePageRepository extends JpaRepository<ChallengePage, Integer> {
}
