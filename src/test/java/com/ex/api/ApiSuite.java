package com.ex.api;

import com.ex.api.DataGenerate.GenerateEmailAndName;
import com.ex.api.Methods.PostMethods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiSuite {

    @Test
    public void testCreateUser() {
        PostMethods postMethods = new PostMethods();

        GenerateEmailAndName randomValues = new GenerateEmailAndName();
        String myName = randomValues.generateName();
        String myEmail = randomValues.generateEmail();

        Response response = postMethods.postCreateUser(
                "e982b587440bf874c3191a20b00cfff1b27cc3b8243723debde280fb0ae444b6",
                "/users",
                201,
                myName,
                myEmail);

        JSONObject responseObject = new JSONObject(response.asString());
        String actualName = "";
        String actualEmail = "";
//        System.out.println(responseObject.get("data"));
        JSONObject data = (JSONObject) responseObject.get("data");
        actualName = String.valueOf(data.get("name"));
        actualEmail = String.valueOf(data.get("email"));

//        System.out.println(actualName + " " + actualEmail);

        Assertions.assertThat(actualName).as("").isEqualTo(myName);
        Assertions.assertThat(actualEmail).as("").isEqualTo(myEmail);
    }
}




