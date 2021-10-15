package com.orangehrmlive.opensourcedemo.page.login;

import com.orangehrmlive.opensourcedemo.model.LoginModel;
import com.orangehrmlive.opensourcedemo.page.common.CommonActionsOnPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Login extends CommonActionsOnPages {
    private LoginModel loginModel;

    //For input test cases.
    private final By username = By.id("txtUsername");
    private final By password = By.id("txtPassword");
    private final By submit = By.id("btnLogin");

    private final By home = By.id("branding");
    private final By spanMessage = By.id("spanMessage");


    public Login(WebDriver driver, LoginModel loginModel) {
        super(driver);
        this.loginModel = loginModel;
    }
    public Login(WebDriver driver, LoginModel loginModel, int secondsForExplicitWait) {

        super(driver, secondsForExplicitWait);
        this.loginModel = loginModel;

    }


    public void fillLoginPanel() throws IOException {
        clear(username);
        typeInto(username, loginModel.getUsername());

        clear(password);
        typeInto(password, loginModel.getPassword());

        clickOn(submit);

    }
    public boolean isHome(){
        return isDisplayed(home);
    }
    public boolean invalidCredentials(){
        return isDisplayed(spanMessage);
    }


}