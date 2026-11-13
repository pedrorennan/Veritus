package com.example.Veritus.mapper;

import com.example.Veritus.dto.JogadorResponseDTO;
import com.example.Veritus.model.Jogador;

public class JogadorMapper {
    public static JogadorResponseDTO toJogadorResponse(Jogador jogador) {
        return new JogadorResponseDTO(
                jogador.getId(),
                jogador.getNome(),
                jogador.getEmail()
        );

    }
}
