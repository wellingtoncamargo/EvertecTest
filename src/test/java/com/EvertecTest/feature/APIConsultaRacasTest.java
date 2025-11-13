package com.EvertecTest.feature;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.EvertecTest.config.EnvVariables.BASE_URL;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

@Tag("API")
@Epic("Dogs")
@Feature("Validando de consulta geral")
public class APIConsultaRacasTest {

    public JSONObject _json;
    private static String baseURI;

    @BeforeClass
    public static void setUp(){
        baseURI = BASE_URL;
    }

    @Test
    @Tag("positivo")
    @DisplayName("Consultando dados de todas raças")
    @Description("Esperando status 200")
    public void ConsultaApiTodasRacas() {
        Response resp = RestAssured
                .given()
                .when()
                .get(baseURI + "/breeds/list/all");
        resp.then()
                .assertThat()
                .statusCode(200)
                .body("message.keySet()", hasItem("retriever"))
                .body("message.retriever", notNullValue())
                .body("message.retriever.size()", equalTo(4));
    }

    @Test
    @Tag("positivo")
    @DisplayName("Consultando dados de imagens por raça especifica")
    @Description("Esperando status 200 e que contenha uma lista de imagens")
    public void ConsultaListaImagens() {
        Response resp = RestAssured
                .given()
                .when()
                .get(baseURI + "/breed/retriever/images");
        resp.then()
                .assertThat()
                .statusCode(200)
                .body("message.size()", greaterThan(0));
    }

    @Test
    @Tag("positivo")
    @DisplayName("Consultando dados de imagem por raça Aleatória")
    @Description("Esperando status 200 e que contenha uma imagem aleatoria")
    public void ConsultaImagensAleatorias() {
        Response resp = RestAssured
                .given()
                .when()
                .get(baseURI + "/breeds/image/random");
        resp.then()
                .assertThat()
                .statusCode(200)
                .body("message.size()", notNullValue())
                .extract().response();

        Response resp2 = RestAssured
                .given()
                .when()
                .get(baseURI + "/breeds/image/random");
        resp2.then()
                .assertThat()
                .statusCode(200)
                .body("message.size()", notNullValue())
                .extract().response();
        var temimagem = resp.jsonPath().get("message");
        var temimagem2 = resp2.jsonPath().get("message");
        Assert.assertNotEquals(temimagem,temimagem2);
    }

}
