package br.com.beholder.compras.utils;

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
            return Double.parseDouble(valorLimpo);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Texto de preço inválido: " + texto, e);
        }
    }
}
