package com.qacart.todo.TestCases;

import com.qacart.todo.Api.RegisterApi;
import com.qacart.todo.DriverFactory.DriverFactory;
import com.qacart.todo.Pages.LoginPage;
import com.qacart.todo.Pages.TodoPage;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.utils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
@Feature("Auth Feature")

public class LoginTest extends BaseTest {

    @Story("Login with Email and Password")
    @Description("It will login by filling Email and Password and navigate to Todo page")
    @Test(description = "Test The login functionality using email and password")
    public void shouldBeAbleToLoginWithEmailAndPassword(){

       LoginPage loginpage =new LoginPage( getDriver());


        boolean IsWelcomeDisplayed= loginpage
                .load()
                .login(ConfigUtils.GetInstance().GetEmail(), ConfigUtils.GetInstance().GetPassword())
                .ISWelcomeMessageDisplayed();



        Assert.assertTrue(IsWelcomeDisplayed);
    }
}
