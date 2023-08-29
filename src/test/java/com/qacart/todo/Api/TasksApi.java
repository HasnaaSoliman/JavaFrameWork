package com.qacart.todo.Api;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.Tasks;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TasksApi {
    public void addTask(String Token){
        Tasks tasks=new Tasks(false,"Learn Selenium");
        Response response=
        given()
                .baseUri("https://qacart-todo.herokuapp.com")
                .header("Content-Type","application/json")
                .body(tasks)
                .auth().oauth2(Token)
        .when()
                .post(EndPoint.API_TASKSENDPOINT)
        .then()
                .log().all()
                .extract().response();
        if(response.statusCode()!=201){
            throw new RuntimeException("something went wrong with the request");
        }

    }
}
