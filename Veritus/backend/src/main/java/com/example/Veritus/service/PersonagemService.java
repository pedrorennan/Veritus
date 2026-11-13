package com.example.Veritus.service;

import com.example.Veritus.dto.PersonagemRequestDTO;
import com.example.Veritus.exceptions.ResourceExists;
import com.example.Veritus.model.Jogador;
import com.example.Veritus.model.Personagem;
import com.example.Veritus.repository.JogadorRepository;
import com.example.Veritus.repository.PersonagemRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class PersonagemService {

    private final JogadorRepository jogadorRepository;
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    private final PersonagemRepository personagemRepository;

    public PersonagemService(PersonagemRepository personagemRepository, JogadorRepository jogadorRepository) {
        this.personagemRepository = personagemRepository;
        this.jogadorRepository = jogadorRepository;
    }

    public Personagem criar(PersonagemRequestDTO dto) {
        Personagem personagem = new Personagem();

        Jogador jogadorSessao = (Jogador) auth.getPrincipal();
        Jogador jogador = jogadorRepository.getReferenceById(jogadorSessao.getId());

        personagem.setNomeJogador(jogador);
        personagem.setNivel(dto.nivel());
        personagem.setNomePersonagem(dto.nomePersonagem());
        personagem.setPerfil(dto.perfil());
        personagem.setVocacao(dto.vocacao());

        Personagem salvo = jogadorRepository.save(personagem);

        return
    }
}
