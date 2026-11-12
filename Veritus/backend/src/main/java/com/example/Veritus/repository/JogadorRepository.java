package com.example.Veritus.repository;

import com.example.Veritus.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {
    boolean existsByEmail(String email);
}
