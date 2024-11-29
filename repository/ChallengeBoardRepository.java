package com.example.joinup.challengeboard.repository;

import com.example.joinup.challengeboard.entity.ChallengeBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeBoardRepository extends JpaRepository<ChallengeBoard, Integer> {
}
