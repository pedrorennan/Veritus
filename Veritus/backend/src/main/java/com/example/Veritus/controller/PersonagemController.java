package com.example.Veritus.controller;

import com.example.Veritus.dto.PersonagemRequestDTO;
import com.example.Veritus.repository.PersonagemRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personagens")
public class PersonagemController {

    private final PersonagemRepository personagemRepository;

    public PersonagemController(PersonagemRepository personagemRepository) {
        this.personagemRepository = personagemRepository;
    }

    @PostMapping()
    public ResponseEntity<?> criarPJ(
            @Valid @RequestBody PersonagemRequestDTO dto
            ){

    }
}
