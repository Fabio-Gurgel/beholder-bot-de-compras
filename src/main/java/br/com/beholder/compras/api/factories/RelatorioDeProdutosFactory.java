package br.com.beholder.compras.api.factories;

import br.com.beholder.compras.api.dtos.ProdutoEncontradoDTO;
import br.com.beholder.compras.api.dtos.RelatorioDeProdutosDTO;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class RelatorioDeProdutosFactory {

    public static RelatorioDeProdutosDTO montarRelatorio(List<ProdutoEncontradoDTO> produtos) {
        Objects.requireNonNull(produtos, "A lista de produtos não pode ser nula");

        if (produtos.isEmpty()) {
            return new RelatorioDeProdutosDTO(0, null, null, 0.0, List.of());
        }

        ProdutoEncontradoDTO produtoMenorPreco = produtos.stream()
                .min(Comparator.comparingDouble(ProdutoEncontradoDTO::preco))
                .orElseThrow();

        ProdutoEncontradoDTO produtoMaiorPreco = produtos.stream()
                .max(Comparator.comparingDouble(ProdutoEncontradoDTO::preco))
                .orElseThrow();

        double precoMedio = produtos.stream()
                .mapToDouble(ProdutoEncontradoDTO::preco)
                .average()
                .orElse(0.0);

        return new RelatorioDeProdutosDTO(
                produtos.size(),
                produtoMenorPreco,
                produtoMaiorPreco,
                precoMedio,
                List.copyOf(produtos)
        );
    }
}
