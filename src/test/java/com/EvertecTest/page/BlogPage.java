package com.EvertecTest.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.time.Duration;

public class BlogPage extends BasePage {

    @FindBy(xpath = "//*[@aria-label=\"Search button\"]")
    private WebElement btnPesquisa ;

    @FindBy(id = "search-field")
    private WebElement campoPesquisa;

    @FindBy(xpath = "//*[@class=\"page-title ast-archive-title\"]")
    private WebElement textoTituloPesquisa;


    public BlogPage(WebDriver driver) {
        super(driver);
    }

    public void abreNavegador(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://blogdoagi.com.br/");
    }

    public void realizaConsulta(String consulta) throws InterruptedException {
        Thread.sleep(3000);
        btnPesquisa.isDisplayed();
        btnPesquisa.click();
        campoPesquisa.sendKeys(consulta);
        campoPesquisa.submit();
    }

    public void validaTextoConsulta(String texto) throws InterruptedException {
        Thread.sleep(3000);
        textoTituloPesquisa.isDisplayed();
        Assert.assertEquals(texto, textoTituloPesquisa.getText());
    }

    public void validaTextoSemAssuntoConsulta(String texto) throws InterruptedException {
        Thread.sleep(3000);
        textoTituloPesquisa.isDisplayed();
        Assert.assertNotEquals(texto, textoTituloPesquisa.getText());
    }
}
