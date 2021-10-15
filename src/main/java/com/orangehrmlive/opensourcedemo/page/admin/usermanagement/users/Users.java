package com.orangehrmlive.opensourcedemo.page.admin.usermanagement.users;

import com.orangehrmlive.opensourcedemo.model.admin.usermanagement.users.UsersModel;
import com.orangehrmlive.opensourcedemo.page.common.CommonActionsOnPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Users extends CommonActionsOnPages {
    private UsersModel usersModel;

    private final By username = By.id("txtUsername");
    private final By password = By.id("txtPassword");
    private final By submit = By.id("btnLogin");
    private final By adminHome = By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b");
    private final By userManagementHome=By.id("menu_admin_UserManagement");
    private final By userHome=By.id("menu_admin_viewSystemUsers");

    private final By systemUsersStatus=By.id("searchSystemUser_status");
    private final By systemUsersSearch=By.id("searchBtn");

    private final By systemUsersSearchAll=By.xpath("//*[@id=\"searchSystemUser_status\"]/option[1]");
    private final By systemUsersSearchEnabled=By.xpath("//*[@id=\"searchSystemUser_status\"]/option[2]");
    private final By systemUsersSearchDisabled=By.xpath("//*[@id=\"searchSystemUser_status\"]/option[3]");



    private final By tableWrapper =By.id("tableWrapper");


    public Users(WebDriver driver, UsersModel administrativeModel) {
        super(driver);
        this.usersModel = administrativeModel;
    }
    public Users(WebDriver driver, UsersModel administrativeModel, int secondsForExplicitWait) {

        super(driver, secondsForExplicitWait);
        this.usersModel = administrativeModel;

    }

    public void fillLoginPanel() throws IOException {
        clear(username);
        typeInto(username, usersModel.getUsername());
        clear(password);
        typeInto(password, usersModel.getPassword());
        clickOn(submit);
    }
    public void pathAdminUsermanagementUsers(){
        clickOn(adminHome);
        clickOn(userManagementHome);
        clickOn(userHome);
    }

    public void searchStatus(String status){
        clickOn(systemUsersStatus);

        if (status=="All"){
            clickOn(systemUsersSearchAll);
        }else if(status=="Enable"){
            clickOn(systemUsersSearchEnabled);
        }else  if(status=="Disable"){
            clickOn(systemUsersSearchDisabled);
        }

        clickOn(systemUsersSearch);
    }
    public boolean isTableWrapper(){
        return  isDisplayed(tableWrapper);
    }


}
