package com.example.Veritus.service;

import com.example.Veritus.dto.JogadorRequestDTO;
import com.example.Veritus.dto.JogadorResponseDTO;
import com.example.Veritus.model.Jogador;
import com.example.Veritus.repository.JogadorRepository;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class JogadorService {

    private final JogadorRepository jogadorRepository;

    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    public Jogador criar(JogadorRequestDTO dto) {

        Jogador jogador = new Jogador();
        jogador.setNome(dto.nome());
        jogador.setEmail(dto.email());

        return jogadorRepository.save(jogador);
    }

}
