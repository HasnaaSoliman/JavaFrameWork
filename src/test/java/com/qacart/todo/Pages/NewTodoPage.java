package com.qacart.todo.Pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTodoPage extends BasePage {
    public NewTodoPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css="[data-testid=\"new-todo\"]")
    private WebElement newtodoinput;

    @FindBy(css="[data-testid=\"submit-newTask\"]")
    private WebElement newtodosubmit;
    @Step
    public TodoPage AddNewTodoTask(String item){
        newtodoinput.sendKeys(item);
        newtodosubmit.click();
        return new TodoPage(driver);
    }
    @Step
    public NewTodoPage load(){
        driver.get(ConfigUtils.GetInstance().GetBaseUrl()+ EndPoint.API_NEW_TODOENDPOINT);
        return this;
    }


}
