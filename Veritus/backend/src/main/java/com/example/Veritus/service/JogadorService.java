package com.example.Veritus.service;

import com.example.Veritus.dto.JogadorRequestDTO;
import com.example.Veritus.dto.JogadorResponseDTO;
import com.example.Veritus.model.Jogador;
import com.example.Veritus.repository.JogadorRepository;
import org.springframework.stereotype.Service;

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
