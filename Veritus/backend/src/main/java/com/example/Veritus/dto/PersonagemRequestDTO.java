package com.example.Veritus.dto;

import com.example.Veritus.model.Atributos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PersonagemRequestDTO (
        @NotBlank
        String nomePersonagem,

        @NotNull
        int nivel,

        @NotBlank
        String vocacao,

        @NotBlank
        String perfil

) {
}
