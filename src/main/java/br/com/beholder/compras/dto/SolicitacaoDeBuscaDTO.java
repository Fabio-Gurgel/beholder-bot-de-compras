package br.com.beholder.compras.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record SolicitacaoDeBuscaDTO(
        @NotBlank(message = "O nome do produto é obrigatório")
        String nomeProduto,

        @Positive(message = "O preço esperado deve ser maior que zero")
        double precoEsperado
) {}
