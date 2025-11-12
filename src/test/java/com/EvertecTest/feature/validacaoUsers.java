package com.EvertecTest.feature;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.EvertecTest.config.EnvVariables.BASE_URL;
import static org.hamcrest.Matchers.equalTo;

@Tag("API")
@Epic("Usarios")
@Feature("Validando api Users")
public class validacaoUsers {

    public JSONObject _json;
    private static String baseURI;

    @BeforeClass
    public static void setUp(){
        baseURI = BASE_URL;
    }

    @Test
    @Tag("positivo")
    @DisplayName("Consultando usuarios cadastrados por id na base")
    @Description("Esperando status 200")
    public void ConsultaApiUser() {
        Response resp = RestAssured
                .given()
                .when()
                .get(baseURI + "/users");
        resp.then()
                .assertThat()
                .statusCode(200)
                .body("users[0].username", equalTo("emilys"))
                .body("users[0].password", equalTo("emilyspass"));
    }

    @Test
    @Tag("positivo")
    @DisplayName("Consultando usuario cadastrado por id na base")
    @Description("Informando um id cadastrado na base e esperando status 200")
    public void ConsultaApiUserPorId() throws JSONException {
        Response resp = RestAssured
                .given()
                .when()
                .get(baseURI + "/users/1");
        resp.then()
                .assertThat()
                .statusCode(200)
                .body("username", equalTo("emilys"))
                .body("password", equalTo("emilyspass"));
        _json = new JSONObject(resp.getBody().asString());

    }

    @Test
    @Tag("negativo")
    @DisplayName("Consultando usuario não cadastrado por id invalido")
    @Description("Informando id não existente na base esperando uma mensagem de erro e status 404")
    public void onsultaDeUsuarioInvalidoApiUserPorId() {
        Response resp = RestAssured
                .given()
                .when()
                .get(baseURI + "/users/3322");
        resp.then()
                .assertThat()
                .statusCode(404);

    }

    @Test
    @Tag("negativo")
    @DisplayName("Consultando usuario não cadastrado por id com texto")
    @Description("Informando texto no lugar de um id esperando uma mensagem de erro e status 400")
    public void ConsultaDeUsuarioInvalidoApiUserPorTexto() {
        Response resp = RestAssured
                .given()
                .when()
                .get(baseURI + "/users/texto");
        resp.then()
                .assertThat()
                .statusCode(400);
    }

    @Test
    @Tag("negativo")
    @DisplayName("Alterando informações de usuario")
    @Description("Alterando informações de um usuario da base esperando uma mensagem de erro e status 301")
    public void AlteracaoDeUsuarioNaApiUserPorId() throws JSONException {
        ConsultaApiUserPorId();
        _json = _json.put("firstName", "Valter");
        Response resp = RestAssured
                .given()
                .body(_json.toString())
                .when()
                .put(baseURI + "/users/1");
        resp.then()
                .assertThat()
                .statusCode(301);
    }

    @Test
    @Tag("negativo")
    @DisplayName("Criando um novo usuario")
    @Description("Criando um novo usuario da base esperando uma mensagem de erro e status 301")
    public void CriacaoDeUsuarioNaApiUser() throws JSONException {
        ConsultaApiUserPorId();
        _json.remove("id");
        _json = _json.put("firstName", "Valter");
        Response resp = RestAssured
                .given()
                .body(_json.toString())
                .when()
                .post(baseURI + "/users");
        resp.then()
                .assertThat()
                .statusCode(301);
    }
}
