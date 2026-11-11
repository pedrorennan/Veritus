package com.example.Veritus.controller;

import com.example.Veritus.dto.JogadorRequestDTO;
import com.example.Veritus.dto.JogadorResponseDTO;
import com.example.Veritus.mapper.JogadorMapper;
import com.example.Veritus.model.Jogador;
import com.example.Veritus.service.JogadorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perfil")
public class JogadorController {

    private final JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @PostMapping("/registrar")
    public JogadorResponseDTO login(@Valid @RequestBody JogadorRequestDTO dto) {
        Jogador jogador = jogadorService.criar(dto);
        return JogadorMapper.toJogadorResponse(jogador);
    }

}
