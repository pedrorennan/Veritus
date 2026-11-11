package com.example.Veritus.model;

import jakarta.persistence.*;

@Entity
@Table(name = "atributos_pj")
public class Atributos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "personagem_id", referencedColumnName = "id")
    private Personagem personagem;

    private int fisico;
    private int mente;
    private int emocao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMente() {
        return mente;
    }

    public void setMente(int mente) {
        this.mente = mente;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public int getFisico() {
        return fisico;
    }

    public void setFisico(int fisico) {
        this.fisico = fisico;
    }

    public int getEmocao() {
        return emocao;
    }

    public void setEmocao(int emocao) {
        this.emocao = emocao;
    }
}
