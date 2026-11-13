package com.example.Veritus.controller;

import com.example.Veritus.dto.JogadorRequestDTO;
import com.example.Veritus.dto.JogadorResponseDTO;
import com.example.Veritus.dto.LoginDTO;
import com.example.Veritus.model.Jogador;
import com.example.Veritus.repository.JogadorRepository;
import com.example.Veritus.service.JogadorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    private final JogadorService jogadorService;
    private final JogadorRepository jogadorRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SecurityContextRepository securityContextRepository;

    public JogadorController(JogadorService jogadorService, JogadorRepository jogadorRepository) {
        this.jogadorService = jogadorService;
        this.jogadorRepository = jogadorRepository;
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@Valid @RequestBody JogadorRequestDTO dto) {
        Jogador jogador = jogadorService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(jogador.getNome());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @Valid @RequestBody LoginDTO dto,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        return ResponseEntity.ok(jogadorService.login(dto, request, response));
    }

    @GetMapping("")
    public ResponseEntity<List<JogadorResponseDTO>> listar() {
        return ResponseEntity.ok(jogadorService.listar());
    }
}
