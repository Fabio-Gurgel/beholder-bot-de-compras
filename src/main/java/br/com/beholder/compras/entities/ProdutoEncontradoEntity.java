package br.com.beholder.compras.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "produto_encontrado")
public class ProdutoEncontradoEntity {

    public ProdutoEncontradoEntity() {
    }

    public ProdutoEncontradoEntity(Long id, String nome, double preco, String linkParaCompra) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.linkParaCompra = linkParaCompra;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private double preco;

    @Column(nullable = false, length = 1000)
    private String linkParaCompra;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getLinkParaCompra() {
        return linkParaCompra;
    }

    public void setLinkParaCompra(String linkParaCompra) {
        this.linkParaCompra = linkParaCompra;
    }
}
