package com.example.Veritus.dto;

import jakarta.validation.constraints.NotBlank;

public record JogadorRequestDTO (
        @NotBlank
        String nome,

        @NotBlank
        String email
) {}
