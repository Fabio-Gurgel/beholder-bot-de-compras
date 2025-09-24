package br.com.beholder.compras.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "relatorio_de_produtos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RelatorioDeProdutosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "solicitacao_id", nullable = false)
    private SolicitacaoDeBuscaEntity solicitacaoDeBusca;

    @Column(nullable = false)
    private int totalEncontrados;

    @ManyToOne
    @JoinColumn(name = "produto_menor_preco_id")
    private ProdutoEncontradoEntity produtoComMenorPreco;

    @ManyToOne
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
}
