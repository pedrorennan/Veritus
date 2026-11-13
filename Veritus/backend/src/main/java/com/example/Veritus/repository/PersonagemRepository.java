package com.example.Veritus.repository;

import com.example.Veritus.model.Personagem;
import org.aspectj.weaver.patterns.PerObject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
    boolean existsById(Long id);
}
