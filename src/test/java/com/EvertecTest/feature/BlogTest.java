package com.EvertecTest.feature;

import com.EvertecTest.core.SeleniumBase;
import com.EvertecTest.page.BasePage;
import com.EvertecTest.page.BlogPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

@Tag("WEB")
@Epic("Consulta Blog")
@Feature("Validando de consulta geral no blog")
public class BlogTest extends SeleniumBase {
    private BlogPage blog;


    @Before
    public void init(){
        setup();
        blog = new BlogPage(driver);
        blog.abreNavegador();
    }

    @After
    public void end(){
        tearDown();
    }

    @Test
    @Tag("positivo")
    @DisplayName("Consultando por assuntos da pagina")
    @Description("Esperando que o Título da pesquisa seja apresentado com o assunto")
    public void deveRealizarUmaConsulta() throws InterruptedException {
        blog.realizaConsulta("Prevenção");
        blog.validaTextoConsulta("Resultados encontrados para: Prevenção");
    }

    @Test
    @Tag("positivo")
    @DisplayName("Consultando sem assunto especifico")
    @Description("Esperando que o campo de pesquisa apresente uma mensagem solicitando assunto.")
    public void deveRealizarUmaConsultaSemAssunto() throws InterruptedException {
        blog.realizaConsulta("");
        blog.validaTextoSemAssuntoConsulta("Resultados encontrados para:");
    }
}
