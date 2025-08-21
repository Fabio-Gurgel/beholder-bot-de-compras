package br.com.beholder.compras.botcore.abstracts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class Bot {

    protected WebDriver browser;

    public Bot(WebDriver browser) {
        System.setProperty("webdriver.chrome.driver", "src\\main\\java\\br\\com\\beholder\\compras\\botcore\\drivers\\chromedriver-win64\\chromedriver.exe");
        if (browser != null) {
            this.browser = browser;
        } else {
            this.browser = new ChromeDriver();
        }
    }

    public void esperarPaginaCarregarCompletamente() {
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(30));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }

    public void fechar() {
        this.browser.quit();
    }
}
