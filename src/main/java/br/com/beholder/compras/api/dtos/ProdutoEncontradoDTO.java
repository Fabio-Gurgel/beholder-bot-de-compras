package br.com.beholder.compras.api.dtos;

public record ProdutoEncontradoDTO(
        String nome,
        double preco,
        String linkParaCompra
) {}
