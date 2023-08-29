package com.qacart.todo.Pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.utils.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id="email")
            private WebElement EmailInput;

    @FindBy (id="password")
    private WebElement PasswordInput;

    @FindBy (id="submit")
    private WebElement SubmitInput;
@Step("Load Login Page")
    public LoginPage load(){


        driver.get(ConfigUtils.GetInstance().GetBaseUrl());
      /* Properties pros= PropertiesUtils.loadproperties("src/test/java/com/qacart/todo/config/production.properties");
        driver.get(pros.getProperty("baseurl"));*/
        return this;
    }
    @Step
    public TodoPage login(String email, String password){
    EmailInput.sendKeys(email);
    PasswordInput.sendKeys(password);
    SubmitInput.click();
    return new TodoPage(driver);

}

}
