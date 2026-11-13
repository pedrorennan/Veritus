package com.example.Veritus.service;

import com.example.Veritus.model.Jogador;
import com.example.Veritus.repository.JogadorRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class JogadorDetailService implements UserDetailsService {

    private final JogadorRepository jogadorRepository;

    public JogadorDetailService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        Jogador jogador = jogadorRepository.findByEmail(email);

        if (jogador == null) {
            throw new RuntimeException("Jogador nao encontrado");
        }

        return jogador;
    }
}