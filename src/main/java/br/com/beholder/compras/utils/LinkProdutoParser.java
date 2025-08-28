package br.com.beholder.compras.utils;

public final class LinkProdutoParser {

    private LinkProdutoParser() {
        // impede instanciação
    }

    public static String extrairLink(String linkParaCompra) {
        if (linkParaCompra != null && !linkParaCompra.startsWith("http")) {
            linkParaCompra = "https://www.amazon.com.br" + linkParaCompra;
        }
        return  linkParaCompra;
    }
}
