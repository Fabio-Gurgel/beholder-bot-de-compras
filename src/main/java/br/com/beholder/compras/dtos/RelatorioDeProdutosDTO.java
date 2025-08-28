package br.com.beholder.compras.dtos;

import java.util.List;

public record RelatorioDeProdutosDTO(
        int totalEncontrados,
        ProdutoEncontradoDTO produtoComMenorPreco,
        ProdutoEncontradoDTO produtoComMaiorPreco,
        double precoMedio,
        List<ProdutoEncontradoDTO> produtosAbaixoDoPreco,
        List<ProdutoEncontradoDTO> produtosAcimaDoPreco
){}
