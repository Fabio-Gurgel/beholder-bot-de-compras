package br.com.beholder.compras.botcore.utils;

public final class NomeProdutoParser {

    private NomeProdutoParser() {
        // impede instanciação
    }

    public static String extrairNome(String texto) {
        if (texto == null || texto.isBlank()) {
            return "";
        }

        String nomeLimpo = texto.replaceFirst("(?i)^\\s*Patrocinado\\s*", "");

        nomeLimpo = nomeLimpo.replace("\n", " ").replaceAll("\\s+", " ").trim();

        return nomeLimpo;
    }
}
