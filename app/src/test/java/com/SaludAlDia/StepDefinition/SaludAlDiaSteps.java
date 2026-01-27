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

        @And("completo registro nuevo usuario")
        public void completarRegistroNuevoUsuario() {
            saludAlDiaPage.clickBtnRegistrarse();
            saludAlDiaPage.sendKeysToRutRegistro("82016989-9");
            saludAlDiaPage.sendKeysToNombreRegistro("Juan");
            saludAlDiaPage.sendKeysToApellidoRegistro("Pérez");
            saludAlDiaPage.sendKeysToEmailRegistro("holaprofe1ng@gmail.com");
            saludAlDiaPage.sendKeysToPasswordRegistro("123456");
            saludAlDiaPage.clickBtnContinuarRegistro();
            saludAlDiaPage.clickAlertRegistro();
        }

        @And("completo ficha medica de usuario paciente")
        public void completarFichaMedicaUsuarioPaciente() {
            saludAlDiaPage.selectTipoSangre("O+");
            saludAlDiaPage.sendKeysEstaturaRegistro("170");
            saludAlDiaPage.sendKeysPeso("89");
            saludAlDiaPage.sendKeysNombreCompletoEmergencia("Gatito Salvador");
            saludAlDiaPage.sendKeysToFonoEmergencia("987654321");
            saludAlDiaPage.sendKeysAlergias("Pasto, polvo y colores fuertes");
            saludAlDiaPage.sendKeysInputEnfermedadesCronicas("Hipertensión y diabetes");
            saludAlDiaPage.clickChkDataProcessingConsent();
            saludAlDiaPage.clickBtnGuardarFichaMedica();
            saludAlDiaPage.clickAlertRegistro();
        }

    @And("ingreso con mis credenciales de administrador al portal privado paciente")
    public void ingresoAlLoginAdministrador() {
        saludAlDiaPage.clickBtnLogin();
        saludAlDiaPage.sendKeysToEmail("adminy@gmail.com");
        saludAlDiaPage.sendKeysToPassword("yeider360");
        saludAlDiaPage.clickBtnLoginSubmit();
    }

    @And("valido que el administrador tenga acceso a agregar un especialista")
    public void validarAccesoAgregarEspecialista() {
        Assert.assertTrue("El botón de agregar especialista no es visible", saludAlDiaPage.isVisibleBtnCreateSpecialist());
    }

    @And("valido que el administrador tenga acceso a la lista de usuarios registrados")
    public void validarAccesoListaUsuariosRegistrados() {
        Assert.assertTrue("El botón de lista de usuarios no es visible", saludAlDiaPage.isVisibleLabelListaUsuarios());
    }

    @And("valido que accede al panel de control de administrador")
    public void validarPanelDeControlAdministrador() {
        Assert.assertTrue("El panel de control de administrador no es visible", saludAlDiaPage.isVisibleLabelPanelControl());
    }

    @And("ingreso con mis credenciales de especialista al portal privado paciente")
    public void ingresoAlLoginEspecialista() {
        saludAlDiaPage.clickBtnLogin();
        saludAlDiaPage.sendKeysToEmail("vic@gmail.com");
        saludAlDiaPage.sendKeysToPassword("Victor360_");
        saludAlDiaPage.clickBtnLoginSubmit();
    }

    @And("valido que el especialista tenga acceso al panel de pacientes asignados")
    public void validarAccesoListaPacientesAsignados() {
        Assert.assertTrue("El botón de lista de pacientes asignados no es visible", saludAlDiaPage.isVisibleLabelPanelEspecialista());
        Assert.assertTrue("El botón de lista de pacientes asignados no es visible", saludAlDiaPage.isVisibleListaPacientes());
    }

    @Then("valido que al hacer click en ver ficha medica de un paciente se despliegue la informacion correctamente")
    public void validarVerFichaMedicaPaciente() {
        saludAlDiaPage.clickBtnVerFichaMedicaPaciente();
        Assert.assertTrue("La información de la ficha médica no es visible", saludAlDiaPage.isVisibleLabelFichaMedicaPaciente());
    }


}