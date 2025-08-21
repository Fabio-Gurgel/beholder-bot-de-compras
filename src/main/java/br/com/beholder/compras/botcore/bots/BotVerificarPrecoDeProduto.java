package br.com.beholder.compras.botcore.bots;

import br.com.beholder.compras.api.dtos.SolicitacaoDeBuscaDTO;
import br.com.beholder.compras.botcore.abstracts.Bot;
import br.com.beholder.compras.api.dtos.ProdutoEncontradoDTO;
import br.com.beholder.compras.api.dtos.RelatorioDeProdutosDTO;
import br.com.beholder.compras.api.factories.RelatorioDeProdutosFactory;
import br.com.beholder.compras.botcore.utils.NomeProdutoParser;
import br.com.beholder.compras.botcore.utils.PrecoParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BotVerificarPrecoDeProduto extends Bot {

    private final List<ProdutoEncontradoDTO> produtosEncontradosDTOs = new ArrayList<>();

    public BotVerificarPrecoDeProduto(WebDriver browser) {
        super(browser);
    }

    public RelatorioDeProdutosDTO executar(SolicitacaoDeBuscaDTO solicitacao) {
        acessarSiteDaAmazon();
        continuarParaTelaPrincipal();
        preencherCampoDeBusca(solicitacao.nomeProduto());

        super.esperarPaginaCarregarCompletamente();
        listarProdutosEncontrados();

        browser.quit();
        return RelatorioDeProdutosFactory.montarRelatorio(produtosEncontradosDTOs, solicitacao.precoEsperado());
    }

    private void acessarSiteDaAmazon() {
        String URL_ACESSO_AMAZON = "https://www.amazon.com.br";
        browser.navigate().to(URL_ACESSO_AMAZON);
    }

    private void continuarParaTelaPrincipal() {
        List<WebElement> botoes = browser.findElements(By.xpath("//button[text()='Continuar comprando']"));
        if (!botoes.isEmpty()) {
            botoes.get(0).click();
        }
    }

    private void preencherCampoDeBusca(String termoDeBusca) {
        WebElement campoBusca = browser.findElement(By.id("twotabsearchtextbox"));
        campoBusca.sendKeys(termoDeBusca);
        campoBusca.sendKeys(Keys.ENTER);
    }

    private void listarProdutosEncontrados() {
        List<WebElement> produtosElements = browser.findElements(By.cssSelector("[data-cy='asin-faceout-container']"));

        for (WebElement produtoWebElement : produtosElements) {
            WebElement nomeElement = produtoWebElement.findElement(By.cssSelector("[data-cy='title-recipe']"));
            List<WebElement> precoElement = produtoWebElement.findElements(By.cssSelector("[data-cy='price-recipe'] .a-price"));

            if (precoElement.isEmpty()) return;

            String nome = NomeProdutoParser.extrairNome(nomeElement.getText());
            double preco = PrecoParser.extrairPreco(precoElement.get(0).getText());

            ProdutoEncontradoDTO produtoEncontrado = new ProdutoEncontradoDTO(nome, preco);
            produtosEncontradosDTOs.add(produtoEncontrado);
        }
    }
}
