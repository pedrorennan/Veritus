package com.example.Veritus.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JogadorResponseDTO {
    Long id;
    String nome;
    String email;
}
