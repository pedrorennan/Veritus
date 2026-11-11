package com.example.Veritus.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JogadorResponseDTO {
    String nome;
    String email;


}
