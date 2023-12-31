package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By botaoAbrePesquisa = By.id("search-open");
    private final By campoPesquisa = By.className("search-field");
    private final By botaoPesquisa = By.className("search-submit");

    public homePage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void navegar() {
        driver.get("https://blogdoagi.com.br/");
    }

    public void abrirPesquisa() {
        wait.until(ExpectedConditions.elementToBeClickable(botaoAbrePesquisa)).click();
    }

    public void preencherPalavraPesquisa(String Texto) {
        wait.until(ExpectedConditions.elementToBeClickable(campoPesquisa)).sendKeys(Texto);
    }

    public void pesquisar() {
        wait.until(ExpectedConditions.elementToBeClickable(botaoPesquisa)).click();
    }
}
