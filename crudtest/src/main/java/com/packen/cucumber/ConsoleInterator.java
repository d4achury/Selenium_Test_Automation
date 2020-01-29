package com.packen.cucumber;


import com.packen.BrowserManage.BrowserInteractor;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;


public class ConsoleInterator {

    BrowserInteractor browserInteractor = null;

    @Given("^Se inicio el navegador$")
    public void seInicioElNavegador() throws Exception {
        this.browserInteractor = BrowserInteractor.getInstance();

    }


    @And("^La aplicacion esta desplegada en la \"([^\"]*)\"$")
    public void laAplicacionEstaDesplegadaEnLaURL(String url) throws Exception {
        browserInteractor.getWebDriver().get(url);
    }

    @When("^Se navego a la aplicacion$")
    public void seNavegoALaAplicacion() {
        System.out.println("Se Navego a la URL");
    }

    @And("^Se ingreso el \"([^\"]*)\" y el \"([^\"]*)\"$")
    public void seIngresoElNombreYElApellido(String nombre, String apellido) throws Exception {
        String xpathNombre = "/html/body/app-root/div[2]/div/div/form/div[1]/input";
        String xpathApellido = "/html/body/app-root/div[2]/div/div/form/div[2]/input";


        BrowserInteractor.waitForPageToLoad(browserInteractor.getWebDriver(), xpathNombre);
        BrowserInteractor.waitForPageToLoad(browserInteractor.getWebDriver(), xpathApellido);

        browserInteractor.getWebDriver().findElement(By.xpath(xpathNombre)).sendKeys(nombre);

        browserInteractor.getWebDriver().findElement(By.xpath(xpathApellido)).sendKeys(apellido);

    }

    @And("^Se dio click en el boton de Login$")
    public void seDioClickEnElBotonDeLogin() throws Exception {
        String boton = "/html/body/app-root/div[2]/div/div/form/div[3]/div[1]/button";
        BrowserInteractor.waitForPageToLoad(browserInteractor.getWebDriver(), boton);
        browserInteractor.getWebDriver().findElement(By.xpath(boton)).click();

    }


    @Then("^Se inicio session exitosamente$")
    public void seInicioSessionExitosamente() {

    }


}
