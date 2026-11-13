package com.example.Veritus.service;

import com.example.Veritus.dto.JogadorRequestDTO;
import com.example.Veritus.dto.JogadorResponseDTO;
import com.example.Veritus.dto.LoginDTO;
import com.example.Veritus.exceptions.ResourceExists;
import com.example.Veritus.model.Jogador;
import com.example.Veritus.repository.JogadorRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.Veritus.mapper.JogadorMapper;

@Service
public class JogadorService {

    private final JogadorRepository jogadorRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SecurityContextRepository securityContextRepository;

    public JogadorService(JogadorRepository jogadorRepository, PasswordEncoder passwordEncoder) {
        this.jogadorRepository = jogadorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Jogador cadastrar(JogadorRequestDTO dto) {
        if (jogadorRepository.existsByEmail(dto.email())) {
            throw new ResourceExists("Email já está cadastrado");
        }

        Jogador jogador = new Jogador();
        jogador.setNome(dto.nome());
        jogador.setEmail(dto.email());

        jogador.setSenha(passwordEncoder.encode(dto.senha()));

        Jogador salvo = jogadorRepository.save(jogador);

        return salvo;
    }

    public String login(LoginDTO dto, HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.email(), dto.senha())
        );

        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(auth);
        SecurityContextHolder.setContext(context);


        securityContextRepository.saveContext(context, request, response);

        return "Login realizado com sucesso!";
    }

    public List<JogadorResponseDTO> listar() {
        List<Jogador> jogadores = jogadorRepository.findAll();

        if (jogadores.isEmpty()) {
            throw new RuntimeException("Lista de jogadores vazia");
        }

        return jogadores.stream()
                .map(JogadorMapper::toJogadorResponse)
                .toList();

    }

}
