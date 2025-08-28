package br.com.beholder.compras.factories;

import br.com.beholder.compras.utils.LinkProdutoParser;
import br.com.beholder.compras.utils.NomeProdutoParser;
import br.com.beholder.compras.utils.PrecoParser;
import br.com.beholder.compras.dtos.ProdutoEncontradoDTO;
import org.openqa.selenium.WebElement;

public class ProdutoEncontradoDTOFactory {

    public static ProdutoEncontradoDTO criar(WebElement nomeElement, WebElement precoElement, WebElement linkElement) {
        String nome = NomeProdutoParser.extrairNome(nomeElement.getText());
        double preco = PrecoParser.extrairPreco(precoElement.getText());
        String linkParaCompra = LinkProdutoParser.extrairLink(linkElement.getAttribute("href"));

        return new ProdutoEncontradoDTO(nome, preco, linkParaCompra);
    }
}
