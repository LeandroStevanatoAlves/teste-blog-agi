package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class resultPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By textoResultado = By.className("archive-title");
    private By textoSemResultado = By.className("entry-title");

    public resultPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public String titulo(){
        return driver.getTitle();
    }

    public String getTextoResultado(){
        return wait.until(ExpectedConditions.elementToBeClickable(textoResultado)).getText();
    }

    public String getTextoSemResultado(){
        return wait.until(ExpectedConditions.elementToBeClickable(textoSemResultado)).getText();
    }
}
