package com.example.Veritus.dto;

import com.example.Veritus.model.Jogador;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public record JogadorResponseDTO (
        Long id,
        String nome,
        String email
){

    public JogadorResponseDTO(Jogador jogador) {
        this(jogador.getId(), jogador.getNome(), jogador.getEmail());
    }

}
