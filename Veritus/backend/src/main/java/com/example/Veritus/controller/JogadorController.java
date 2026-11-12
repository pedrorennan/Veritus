package com.example.Veritus.controller;

import com.example.Veritus.dto.JogadorRequestDTO;
import com.example.Veritus.dto.JogadorResponseDTO;
import com.example.Veritus.mapper.JogadorMapper;
import com.example.Veritus.model.Jogador;
import com.example.Veritus.repository.JogadorRepository;
import com.example.Veritus.service.JogadorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/perfil")
public class JogadorController {

    private final JogadorService jogadorService;
    private final JogadorRepository jogadorRepository;

    public JogadorController(JogadorService jogadorService, JogadorRepository jogadorRepository) {
        this.jogadorService = jogadorService;
        this.jogadorRepository = jogadorRepository;
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> login(@Valid @RequestBody JogadorRequestDTO dto) {
        if (jogadorRepository.existsByEmail(dto.email())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    Map.of(
                            "Erro",
                            "Email já cadastrado"
                    )
            );
        }
        Jogador jogador = jogadorService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(jogador.getNome());
    }

}
