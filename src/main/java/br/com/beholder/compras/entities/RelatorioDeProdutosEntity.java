package br.com.beholder.compras.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "relatorio_de_produtos")
public class RelatorioDeProdutosEntity {

    public RelatorioDeProdutosEntity() {
    }

    public RelatorioDeProdutosEntity(Long id, SolicitacaoDeBuscaEntity solicitacaoDeBusca, int totalEncontrados, ProdutoEncontradoEntity produtoComMenorPreco, ProdutoEncontradoEntity produtoComMaiorPreco, double precoMedio, List<ProdutoEncontradoEntity> produtosAbaixoDoPreco, List<ProdutoEncontradoEntity> produtosAcimaDoPreco) {
        this.id = id;
        this.solicitacaoDeBusca = solicitacaoDeBusca;
        this.totalEncontrados = totalEncontrados;
        this.produtoComMenorPreco = produtoComMenorPreco;
        this.produtoComMaiorPreco = produtoComMaiorPreco;
        this.precoMedio = precoMedio;
        this.produtosAbaixoDoPreco = produtosAbaixoDoPreco;
        this.produtosAcimaDoPreco = produtosAcimaDoPreco;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "solicitacao_id", nullable = false)
    private SolicitacaoDeBuscaEntity solicitacaoDeBusca;

    @Column(nullable = false)
    private int totalEncontrados;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "produto_menor_preco_id")
    private ProdutoEncontradoEntity produtoComMenorPreco;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "produto_maior_preco_id")
    private ProdutoEncontradoEntity produtoComMaiorPreco;

    @Column(nullable = false)
    private double precoMedio;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "relatorio_produtos_abaixo_preco",
            joinColumns = @JoinColumn(name = "relatorio_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<ProdutoEncontradoEntity> produtosAbaixoDoPreco;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "relatorio_produtos_acima_preco",
            joinColumns = @JoinColumn(name = "relatorio_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<ProdutoEncontradoEntity> produtosAcimaDoPreco;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SolicitacaoDeBuscaEntity getSolicitacaoDeBusca() {
        return solicitacaoDeBusca;
    }

    public void setSolicitacaoDeBusca(SolicitacaoDeBuscaEntity solicitacaoDeBusca) {
        this.solicitacaoDeBusca = solicitacaoDeBusca;
    }

    public int getTotalEncontrados() {
        return totalEncontrados;
    }

    public void setTotalEncontrados(int totalEncontrados) {
        this.totalEncontrados = totalEncontrados;
    }

    public ProdutoEncontradoEntity getProdutoComMenorPreco() {
        return produtoComMenorPreco;
    }

    public void setProdutoComMenorPreco(ProdutoEncontradoEntity produtoComMenorPreco) {
        this.produtoComMenorPreco = produtoComMenorPreco;
    }

    public double getPrecoMedio() {
        return precoMedio;
    }

    public void setPrecoMedio(double precoMedio) {
        this.precoMedio = precoMedio;
    }

    public ProdutoEncontradoEntity getProdutoComMaiorPreco() {
        return produtoComMaiorPreco;
    }

    public void setProdutoComMaiorPreco(ProdutoEncontradoEntity produtoComMaiorPreco) {
        this.produtoComMaiorPreco = produtoComMaiorPreco;
    }

    public List<ProdutoEncontradoEntity> getProdutosAbaixoDoPreco() {
        return produtosAbaixoDoPreco;
    }

    public void setProdutosAbaixoDoPreco(List<ProdutoEncontradoEntity> produtosAbaixoDoPreco) {
        this.produtosAbaixoDoPreco = produtosAbaixoDoPreco;
    }

    public List<ProdutoEncontradoEntity> getProdutosAcimaDoPreco() {
        return produtosAcimaDoPreco;
    }

    public void setProdutosAcimaDoPreco(List<ProdutoEncontradoEntity> produtosAcimaDoPreco) {
        this.produtosAcimaDoPreco = produtosAcimaDoPreco;
    }
}
