package br.com.beholder.compras.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "solicitacao_de_busca")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SolicitacaoDeBuscaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeProduto;

    @Column(nullable = false)
    private double precoEsperado;
}
