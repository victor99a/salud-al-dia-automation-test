package com.SaludAlDia.StepDefinition;

import com.SaludAlDia.Page.SaludAlDiaPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SaludAlDiaSteps {
        WebDriver driver = Hooks.getDriver();
        SaludAlDiaPage saludAlDiaPage = new SaludAlDiaPage(driver);
        // Definimos una espera explícita
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        @Given("que el usuario navega a {string}")
        public void navegarA(String url) {
            driver.get(url);
        }

        @And("ingreso con mis credenciales al portal privado paciente")
        public void ingresoAlLogin() {
            saludAlDiaPage.clickBtnLogin();
            saludAlDiaPage.sendKeysToEmail("tbcest@gmail.com");
            saludAlDiaPage.sendKeysToPassword("123456");
            saludAlDiaPage.clickBtnLoginSubmit();
        }

        @And("deberia ver el panel de control del paciente")
        public void validarPanelDeControl() {
            Assert.assertTrue("El panel de control no es visible", saludAlDiaPage.isVisibleLabelPanelControl());
        }

        @When("registro una nueva toma de datos")
        public void registrarNuevaToma() {
            saludAlDiaPage.clickBtnRegistrarToma();
            saludAlDiaPage.sendKeysToGlucosa("110");
            saludAlDiaPage.sendKeysToPresionSistolica("120");
            saludAlDiaPage.sendKeysToPresionDiastolica("89");
            saludAlDiaPage.clickBtnGuardarRegistro();
            saludAlDiaPage.clickAlertRegistro();
        }

        @And("valido que la toma de datos se haya registrado correctamente")
        public void validarRegistroCorrecto() {
            saludAlDiaPage.clickBtnHistorial();
            Assert.assertTrue(saludAlDiaPage.isVisibleLabelHistorial());
            Assert.assertTrue(saludAlDiaPage.isVisibleRegistroConDatos("110","120","89"));
        }

        @Then("valido descarga de archivo PDF con mi historial")
        public void validarDescargaPDF(){
            saludAlDiaPage.limpiarCarpetaDescargas();
            saludAlDiaPage.clickBtnDescargarPDF();
            boolean descargaExitosa = saludAlDiaPage.isPDFDownloaded(".pdf");
            Assert.assertTrue("El archivo PDF no se descargó correctamente", descargaExitosa);
        }

}