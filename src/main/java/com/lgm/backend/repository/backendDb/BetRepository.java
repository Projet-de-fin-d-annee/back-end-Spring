package com.lgm.backend.repository.backendDb;

import com.lgm.backend.model.backendDb.Bet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BetRepository extends JpaRepository<Bet, Integer> {
    List<Bet> findByIsFinished(Boolean isFinished);
    List<Bet> findByUserId_Email(String email);
    boolean existsByMatchIdAndUserId_Email(Integer matchId, String email);

}