package com.orangehrmlive.opensourcedemo.stepdefinition.login;

import com.orangehrmlive.opensourcedemo.model.LoginModel;
import com.orangehrmlive.opensourcedemo.page.login.Login;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import com.orangehrmlive.opensourcedemo.stepdefinition.setup.WebUI;


public class LoginCucumberStepDefinition extends WebUI{
    private static final Logger LOGGER = Logger.getLogger(LoginCucumberStepDefinition.class);
    private LoginModel loginmodel;
    private Login login;
    private static final String ASSERTION_EXCEPTION_MESSAGE = "Los valores suministrados no son los esperados.";
    private int TEN_SECONDS=10;
    @Given("El empleado ingresa a la página principal donde se le solicita usuario y contraseña")
    public void elEmpleadoIngresaALaPaginaPrincipalDondeSolicitaUsuarioYContraseña() {
        try {
            generalSetUp();
        }catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }
    @When("El empleado introduce en el campo usuario el usuario correcto y el campo password la contraseña correcta y dará clic en el botón login")
    public void elEmpleadoIntroduceEnElCampoUsuarioElUsuarioCorrectoYElCampoPasswordLaContraseñaCorrectaYDaráClicEnElBotónLogin() {
        // Write code here that turns the phrase above into concrete actions
        try {
            LoginModel loginModel = new LoginModel();
            loginModel.setUsername("Admin");
            loginModel.setPassword("admin123");
            login = new Login(driver, loginModel,10);
            login.fillLoginPanel();

        }catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }
    @Then("El sistema le dará acceso y lo llevara al home de la página.")
    public void elSistemaLeDaraAccesoYLoLlevaraAlHomeDeLaPagina() {
        // Write code here that turns the phrase above into concrete actions
        if (login.isHome()){
            quitDriver();
        }else{
            Assertions.fail(ASSERTION_EXCEPTION_MESSAGE);
            quitDriver();
        }
    }


    @When("El empleado introduce en el campo usuario un usuario valido y en el campo de password introduce una contraseña incorrecta y dará clic en el botón login")
    public void elEmpleadoIntroduceEnElCampoUsuarioUnUsuarioValidoYEnElCampoDePasswordIntroduceUnaContraseñaIncorrectaYDaráClicEnElBotónLogin() {
        try {
            LoginModel loginModel = new LoginModel();
            loginModel.setUsername("Admin");
            loginModel.setPassword("adminMAL656");
            login = new Login(driver, loginModel,TEN_SECONDS);
            login.fillLoginPanel();

        }catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @When("El empleado introduce en el campo usuario un usuario no valido y en el campo de password introduce una contraseña valida y dará clic en el botón login")
    public void elEmpleadoIntroduceEnElCampoUsuarioUnUsuarioNoValidoYEnElCampoDePasswordIntroduceUnaContraseñaValidaYDaráClicEnElBotónLogin() {
        // Write code here that turns the phrase above into concrete actions
        try {
            LoginModel loginModel = new LoginModel();
            loginModel.setUsername("AdminMAL");
            loginModel.setPassword("admin123");
            login = new Login(driver, loginModel,TEN_SECONDS);
            login.fillLoginPanel();

        }catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }


    }

    @When("El empleado no introduce ningun usuario y tampoco un password y esta da clic en el botón login")
    public void elEmpleadoNoIntroduceNingunUsuarioYTampocoUnPasswordYEstaDaClicEnElBotónLogin() {
        // Write code here that turns the phrase above into concrete actions
        try {
            LoginModel loginModel = new LoginModel();
            loginModel.setUsername("");
            loginModel.setPassword("");
            login = new Login(driver, loginModel,TEN_SECONDS);
            login.fillLoginPanel();

        }catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @Then("El sistema mostrara un mensaje de error y no podra ingresar")
    public void elSistemaMostraraUnMensajeDeErrorYNoPodraIngresar() {

        if (login.invalidCredentials()){
            quitDriver();
        }else{
            Assertions.fail(ASSERTION_EXCEPTION_MESSAGE);
            quitDriver();
        }
    }
}
