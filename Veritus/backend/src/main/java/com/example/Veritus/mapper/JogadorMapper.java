package com.example.Veritus.mapper;

import com.example.Veritus.dto.JogadorResponseDTO;
import com.example.Veritus.model.Jogador;

public class JogadorMapper {
    public static JogadorResponseDTO toJogadorResponse(Jogador jogador) {
        JogadorResponseDTO jogadorResponseDTO = new JogadorResponseDTO();
        jogadorResponseDTO.setNome(jogador.getNome());
        jogadorResponseDTO.setEmail(jogador.getEmail());

        return jogadorResponseDTO;
    }
}
