package com.qacart.todo.Pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends BasePage {
    public TodoPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (css= "[data-testid=\"welcome\"]")
    private WebElement welcomemessage;

    @FindBy(css="[data-testid=\"add\"]")
    private WebElement addbutton;

    @FindBy(css="[data-testid=\"todo-item\"]")
    private WebElement todoitem;


    @FindBy(css="[data-testid=\"delete\"]")
    private WebElement deletebutton;

    @FindBy(css="[data-testid=\"no-todos\"]")
    private WebElement notodoitem;
    @Step
    public boolean ISWelcomeMessageDisplayed(){
       return welcomemessage.isDisplayed();
    }
    @Step
    public NewTodoPage ClickPlusButton(){
        addbutton.click();
        return new NewTodoPage(driver);
    }
    @Step
    public String TodoItemGetText(){
       return todoitem.getText();
    }
    @Step

    public TodoPage ClickDeleteButton(){
        deletebutton.click();
        return this;

    }
    @Step
    public boolean NoTodoItemIsDisplayed(){
      return   notodoitem.isDisplayed();
    }
    @Step
    public TodoPage load(){
        driver.get(ConfigUtils.GetInstance().GetBaseUrl()+ EndPoint.API_TODO_ENDPOINT);
        return this;
    }
}
