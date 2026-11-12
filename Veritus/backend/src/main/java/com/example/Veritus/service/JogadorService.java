package com.example.Veritus.service;

import com.example.Veritus.config.SecurityConfig;
import com.example.Veritus.dto.JogadorRequestDTO;
import com.example.Veritus.dto.JogadorResponseDTO;
import com.example.Veritus.model.Jogador;
import com.example.Veritus.repository.JogadorRepository;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class JogadorService {

    private final JogadorRepository jogadorRepository;
    private final PasswordEncoder passwordEncoder;

    public JogadorService(JogadorRepository jogadorRepository, PasswordEncoder passwordEncoder) {
        this.jogadorRepository = jogadorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Jogador criar(JogadorRequestDTO dto) {

        Jogador jogador = new Jogador();
        jogador.setNome(dto.nome());
        jogador.setEmail(dto.email());

        jogador.setSenha(passwordEncoder.encode(dto.senha()));

        return jogadorRepository.save(jogador);
    }

}
