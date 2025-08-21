package br.com.beholder.compras.botcore.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class PrecoParser {

    private PrecoParser() {
        // impede instanciação
    }

    public static double extrairPreco(String texto) {
        if (texto == null || texto.isBlank()) return 0.0;

        String valorLimpo = texto.replace("R$", "")
                .replace(".", "")
                .replace("\n", ".")
                .replace(",", ".")
                .replace(" ", "");

        try {
            double valor = Double.parseDouble(valorLimpo);
            return BigDecimal.valueOf(valor)
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Texto de preço inválido: " + texto, e);
        }
    }
}
