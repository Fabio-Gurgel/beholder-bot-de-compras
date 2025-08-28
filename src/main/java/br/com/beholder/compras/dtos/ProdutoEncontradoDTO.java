package br.com.beholder.compras.dtos;

public record ProdutoEncontradoDTO(
        String nome,
        double preco,
        String linkParaCompra
) {}
