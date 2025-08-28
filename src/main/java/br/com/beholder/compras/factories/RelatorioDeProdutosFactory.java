package br.com.beholder.compras.factories;

import br.com.beholder.compras.dtos.ProdutoEncontradoDTO;
import br.com.beholder.compras.dtos.RelatorioDeProdutosDTO;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class RelatorioDeProdutosFactory {

    public static RelatorioDeProdutosDTO montarRelatorio(List<ProdutoEncontradoDTO> produtos, double precoEsperado) {
        Objects.requireNonNull(produtos, "A lista de produtos não pode ser nula");

        if (produtos.isEmpty()) {
            return new RelatorioDeProdutosDTO(0, null, null, 0.0, List.of(), List.of());
        }

        ProdutoEncontradoDTO produtoMenorPreco = produtos.stream()
                .min(Comparator.comparingDouble(ProdutoEncontradoDTO::preco))
                .orElseThrow();

        ProdutoEncontradoDTO produtoMaiorPreco = produtos.stream()
                .max(Comparator.comparingDouble(ProdutoEncontradoDTO::preco))
                .orElseThrow();

        double precoMedio = Math.round(
                produtos.stream()
                        .mapToDouble(ProdutoEncontradoDTO::preco)
                        .average()
                        .orElse(0.0) * 100.0
        ) / 100.0;

        Map<Boolean, List<ProdutoEncontradoDTO>> particionado = produtos.stream()
                .collect(Collectors.partitioningBy(p -> p.preco() < precoEsperado));

        List<ProdutoEncontradoDTO> produtosAbaixo = particionado.get(true);
        List<ProdutoEncontradoDTO> produtosAcima = particionado.get(false);

        return new RelatorioDeProdutosDTO(
                produtos.size(),
                produtoMenorPreco,
                produtoMaiorPreco,
                precoMedio,
                produtosAbaixo,
                produtosAcima
        );
    }
}
