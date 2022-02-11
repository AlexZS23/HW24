package com.ex.api.Methods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostMethods {
    public Response postCreateUser(String token, String resource, int expSC, String name, String email) {
        RestAssured.baseURI = "https://gorest.co.in/public/v1";
        return given()
                .auth().oauth2(token)
                .contentType(ContentType.JSON)
                .body("{\"name\":\"" + name + "\", \"gender\":\"male\", \"email\":\"" + email + "\", \"status\":\"active\"}")
                .when()
                .post(resource)
                .then()
                .assertThat()
                .statusCode(expSC)
                .extract().response();
    }
}
