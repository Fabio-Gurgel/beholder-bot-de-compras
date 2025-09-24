package br.com.beholder.compras.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "produto_encontrado")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoEncontradoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private double preco;

    @Column(nullable = false, length = 1000)
    private String linkParaCompra;
}
