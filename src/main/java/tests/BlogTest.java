package tests;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.homePage;
import pages.resultPage;

import java.time.Duration;

@Execution(ExecutionMode.CONCURRENT)
public class BlogTest {
    private WebDriver driver;
    private WebDriverWait wait;

    private homePage homepage;
    private resultPage resultpage;

    @BeforeEach
    public void iniciaNavegador(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        homepage = new homePage(driver, wait);
        homepage.navegar();

        resultpage = new resultPage(driver, wait);
    }

    @AfterEach
    public void encerraNavegador(){
        driver.close();
    }

    public String montaTitulo(String palavraPesquisa){
        return StringUtils.capitalize(palavraPesquisa).concat(" - Blog Do Agi");
    }

    @Test
    @DisplayName("Pesquisar por uma palavra")
    public void pesquisaUnicaPalavra() {
        String palavraPesquisa = "Teste";
        homepage.abrirPesquisa();
        homepage.preencherPalavraPesquisa(palavraPesquisa);
        homepage.pesquisar();
        Assertions.assertEquals("Resultados da busca por: ".concat(palavraPesquisa), resultpage.getTextoResultado());
        Assertions.assertEquals(this.montaTitulo(palavraPesquisa), resultpage.titulo());
    }


    @Test
    @DisplayName("Pesquisar por múltiplas palavras")
    public void pesquisaMultiplasPalavra() {
        String palavraPesquisa = "Open Banking";
        homepage.abrirPesquisa();
        homepage.preencherPalavraPesquisa(palavraPesquisa);
        homepage.pesquisar();
        Assertions.assertEquals("Resultados da busca por: ".concat(palavraPesquisa), resultpage.getTextoResultado());
        Assertions.assertEquals(this.montaTitulo(palavraPesquisa), resultpage.titulo());
    }

    @Test
    @DisplayName("Pesquisar que não tenha resultado")
    public void pesquisaPalavraSemResultado() {
        String palavraPesquisa = "xyz";
        homepage.abrirPesquisa();
        homepage.preencherPalavraPesquisa(palavraPesquisa);
        homepage.pesquisar();
        Assertions.assertEquals("Nenhum resultado", resultpage.getTextoSemResultado());
        Assertions.assertEquals(this.montaTitulo(palavraPesquisa), resultpage.titulo());
    }
}
