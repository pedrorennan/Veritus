package com.example.Veritus.controller;

import com.example.Veritus.dto.PersonagemRequestDTO;
import com.example.Veritus.model.Personagem;
import com.example.Veritus.repository.PersonagemRepository;
import com.example.Veritus.service.PersonagemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/personagens")
public class PersonagemController {

    private final PersonagemRepository personagemRepository;
    private final PersonagemService personagemService;

    public PersonagemController(PersonagemRepository personagemRepository, PersonagemService personagemService) {
        this.personagemRepository = personagemRepository;
        this.personagemService = personagemService;
    }

    @PostMapping()
    public ResponseEntity<?> criarPJ(
            @Valid @RequestBody PersonagemRequestDTO dto
            ){
        Personagem personagem = personagemService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "id",personagem.getId(),
                "Jogador", personagem.getNomeJogador()));
    }
}
