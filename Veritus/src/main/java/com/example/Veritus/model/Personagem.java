package model;

import jakarta.persistence.*;

@Entity
@Table(name = "ficha")
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "jogador_id", referencedColumnName = "id")
    private Jogador nomeJogador;

    private String nomePersonagem;
    private int nivel;
    private String vocacao;
    private String perfil;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Jogador getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(Jogador nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public void setNomePersonagem(String nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getVocacao() {
        return vocacao;
    }

    public void setVocacao(String vocacao) {
        this.vocacao = vocacao;
    }
}
