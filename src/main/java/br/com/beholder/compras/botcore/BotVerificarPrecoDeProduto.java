package br.com.beholder.compras.botcore;

import br.com.beholder.compras.botcore.abstratos.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class BotVerificarPrecoDeProduto extends PageObject {

    private final String URL_ACESSO_AMAZON = "https://www.amazon.com.br";

    public BotVerificarPrecoDeProduto(WebDriver browser) {
        super(browser);
    }

    public void executar() {
        acessarSiteDaAmazon();
    }

    private void acessarSiteDaAmazon() {
        browser.navigate().to(URL_ACESSO_AMAZON);

        continuarParaTelaPrincipal();
        preencherCampoDeBusca("iphone");

        super.esperarPaginaCarregarCompletamente();
        listarProdutosEncontrados();
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
        List<WebElement> produtosWebElements = browser.findElements(By.cssSelector("[data-cy='asin-faceout-container']"));

        for (WebElement produtoWebElement : produtosWebElements) {
            WebElement titulo = produtoWebElement.findElement(By.cssSelector("[data-cy='title-recipe']"));
            WebElement preco = produtoWebElement.findElement(By.cssSelector("[data-cy='price-recipe']"));
            System.out.println(titulo.getText());
            System.out.println(preco.getText());
        }
    }
}
