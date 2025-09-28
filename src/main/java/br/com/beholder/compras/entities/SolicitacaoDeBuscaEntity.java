package br.com.beholder.compras.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "solicitacao_de_busca")
public class SolicitacaoDeBuscaEntity {

    public SolicitacaoDeBuscaEntity() {
    }

    public SolicitacaoDeBuscaEntity(Long id, String nomeProduto, double precoEsperado) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.precoEsperado = precoEsperado;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeProduto;

    @Column(nullable = false)
    private double precoEsperado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPrecoEsperado() {
        return precoEsperado;
    }

    public void setPrecoEsperado(double precoEsperado) {
        this.precoEsperado = precoEsperado;
    }
}
