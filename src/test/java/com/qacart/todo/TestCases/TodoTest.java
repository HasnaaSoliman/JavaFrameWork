package com.qacart.todo.TestCases;

import com.qacart.todo.Api.RegisterApi;
import com.qacart.todo.Api.TasksApi;
import com.qacart.todo.DriverFactory.DriverFactory;
import com.qacart.todo.Pages.LoginPage;
import com.qacart.todo.Pages.NewTodoPage;
import com.qacart.todo.Pages.TodoPage;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.objects.Tasks;
import com.qacart.todo.utils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
@Feature("Todo Feature")

public class TodoTest extends BaseTest {
    @Story("Add Todo")
    @Test (description = "Should be able to add new todo correctly")
    public void shouldBeAbleToAddNewTodo() {
        RegisterApi registerApi=new RegisterApi();
        registerApi.register();

        NewTodoPage newtodoPage=new NewTodoPage( getDriver());
        newtodoPage.load();
        injectCookiesToBrowser(registerApi.getRestassuredcookies());
       String actualresult= newtodoPage
                                .load()
                                 .AddNewTodoTask("Learn Selenium")
                                  .TodoItemGetText();

        Assert.assertEquals(actualresult,"Learn Selenium");

    }
    @Story("Delete Todo")
   @Test (description = "Should be able to delete todo correctly")

    public void shouldBeAbleToDeleteTodo(){

       RegisterApi registerApi=new RegisterApi();
       registerApi.register();

       TasksApi tasksApi=new TasksApi();
       tasksApi.addTask(registerApi.getAcesstoken());

       TodoPage todoPage=new TodoPage( getDriver());
       todoPage.load();
       injectCookiesToBrowser(registerApi.getRestassuredcookies());
       Boolean NoTodoMessageIsDisplayed=todoPage
               .load()
               .ClickDeleteButton()
                .NoTodoItemIsDisplayed();

        /*driver.findElement(By.cssSelector("[data-testid=\"add\"]")).click();
        driver.findElement(By.cssSelector("[data-testid=\"new-todo\"]")).sendKeys("Learn Selenium2");
        driver.findElement(By.cssSelector("[data-testid=\"submit-newTask\"]")).click();*/

        Assert.assertTrue(NoTodoMessageIsDisplayed);

    }
}
