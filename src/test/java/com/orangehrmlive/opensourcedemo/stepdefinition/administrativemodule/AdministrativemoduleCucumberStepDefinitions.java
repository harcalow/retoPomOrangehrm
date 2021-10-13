package com.orangehrmlive.opensourcedemo.stepdefinition.administrativemodule;

import com.orangehrmlive.opensourcedemo.model.LoginModel;
import com.orangehrmlive.opensourcedemo.page.login.Login;
import com.orangehrmlive.opensourcedemo.stepdefinition.login.LoginCucumberStepDefinition;
import com.orangehrmlive.opensourcedemo.stepdefinition.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class AdministrativemoduleCucumberStepDefinitions extends WebUI {
    private static final Logger LOGGER = Logger.getLogger(LoginCucumberStepDefinition.class);
    private LoginModel loginmodel;
    private Login login;
    private static final String ASSERTION_EXCEPTION_MESSAGE = "Los valores suministrados no son los esperados.";
    private int TEN_SECONDS=10;
    @Given("El empleado ingresa a la página principal donde se le solicita usuario y contraseña este los ingresa luego de esto ira a Admin luego a User management y users")
    public void elEmpleadoIngresaALaPáginaPrincipalDondeSeLeSolicitaUsuarioYContraseñaEsteLosIngresaLuegoDeEstoIraAAdminLuegoAUserManagementYUsers() {
        try {
            generalSetUp();
            LoginModel loginModel = new LoginModel();
            loginModel.setUsername("Admin");
            loginModel.setPassword("admin123");
            login = new Login(driver, loginModel,TEN_SECONDS);
            login.fillLoginPanel();
            login.pathAdminUsermanagementUsers();
        }catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @When("El empleado seleccionara status y ecogera la opción deseada y finalizara dando clic en Search donde se hará la búsqueda")
    public void elEmpleadoSeleccionaraStatusYEcogeraLaOpciónDeseadaYFinalizaraDandoClicEnSearchDondeSeHaráLaBúsqueda() {
        // Write code here that turns the phrase above into concrete actions
        try {
            login.searchStatus("Enable");
        }catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }

    }
    @Then("Se buscaran los usuarios dependiendo su status")
    public void seBuscaranLosUsuariosDependiendoSuStatus() {
        if (login.isTableWrapper()){
            quitDriver();
        }else{
            Assertions.fail(ASSERTION_EXCEPTION_MESSAGE);
            quitDriver();
        }
    }
}
