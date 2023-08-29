package com.qacart.todo.Api;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.User;
import com.qacart.todo.utils.UerUtils;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {
    private List<Cookie> restassuredcookies;
    private String Acesstoken;
    private String userId;
    private String firstName;

    public List<Cookie> getRestassuredcookies() {
        return this.restassuredcookies;
    }
    public String getAcesstoken() {
        return this.Acesstoken;
    }
    public String getUserId() {
        return this.userId;
    }

    public String getFirstName() {
        return this.firstName;
    }
    public void register(){
        User user=UerUtils.GenerateRandomUser();

        Response response=
                given()
                      .baseUri("https://qacart-todo.herokuapp.com")
                       .header("Content-Type","application/json")
                        .body(user)
                        .log().all()
                .when()
                         .post(EndPoint.API_REGISTERENDPOINT)
                .then()
                // .log().cookies();
                        .log().all()
                         .extract().response();

        if(response.statusCode()!=201){
            throw new RuntimeException("something went wrong with the request");
        }
        restassuredcookies= response.detailedCookies().asList();
        Acesstoken= response.path("access_token");
        userId=response.path("userID");
        firstName=response.path("firstName");

    }

}
