package com.SaludAlDia.Page;

import com.SaludAlDia.StepDefinition.Hooks;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.time.Duration;
import java.util.List;

public class SaludAlDiaPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    @FindBy(xpath = "//a[@class='btn-login']")
    private WebElement btnLogin;

    @FindBy(xpath = "//input[@placeholder='ejemplo@correo.com']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@placeholder='••••••••']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnLoginSubmit;

    @FindBy(xpath = "//h1[normalize-space()='Panel de Control']")
    private WebElement labelPanelControl;

    @FindBy(xpath = "//h2[contains(text(),'Registrar Información')]")
    private WebElement btnRegistrarToma;

    @FindBy(xpath = "//input[@placeholder='Ej: 120']")
    private WebElement inputGlucosa;

    @FindBy(xpath = "//input[@placeholder='Sistólica (Ej: 120)']")
    private WebElement inputPresionSistolica;

    @FindBy(xpath = "//input[@placeholder='Diastólica (Ej: 80)']")
    private WebElement inputPresionDiastolica;

    @FindBy(xpath = "//button[@class='save-btn']")
    private WebElement btnGuardarRegistro;

    @FindBy(xpath = "//a[normalize-space()='Historial']")
    private WebElement btnHistorial;

    @FindBy(xpath = "//h1[normalize-space()='Historial de Mediciones']")
    private WebElement labelHistorial;

    @FindBy(className = "history-item")
    private List<WebElement> listaRegistros;

    @FindBy(xpath = "//button[@class='download-btn pdf']")
    private WebElement btnDescargaPdf;

    @FindBy(xpath = "//a[@class='btn-register']")
    private WebElement btnRegistrarse;

    @FindBy(xpath = "//input[@placeholder='12.345.678-9']")
    private WebElement inputRutRegistro;

    @FindBy(xpath = "//input[@placeholder='Juan Ignacio']")
    private WebElement inputNombreRegistro;

    @FindBy(xpath = "//input[@placeholder='Pérez Soto']")
    private WebElement inputApellidoRegistro;

    @FindBy(xpath = "//input[@placeholder='correo@ejemplo.com']")
    private WebElement inputEmailRegistro;

    @FindBy(xpath = "//input[@placeholder='••••••••']")
    private WebElement inputPasswordRegistro;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnContinuarRegistro;

    @FindBy(xpath = "//select[@name='blood_type']")
    private WebElement cbxTipoSangre;

    @FindBy(xpath = "//input[@placeholder='Ej: 170']")
    private WebElement inputEstatura;

    @FindBy(xpath = "//input[@placeholder='Ej: 75']")
    private WebElement inputPeso;

    @FindBy(xpath = "//input[@placeholder='Nombre completo']")
    private WebElement inputNombreCompletoEmergencia;

    @FindBy(xpath = "//input[@placeholder='9 1234 5678']")
    private WebElement inputFonoEmergencia;

    @FindBy(xpath = "//textarea[@placeholder='Medicamentos, alimentos...']")
    private WebElement inputAlergias;

    @FindBy(xpath = "//textarea[@placeholder='Diabetes, Hipertensión...']")
    private WebElement inputEnfermadadesCronicas;

    @FindBy(xpath = "//input[@name='data_processing_consent']")
    private WebElement chkDataProcessingConsent;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnGuardarFichaMedica;

    public SaludAlDiaPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickBtnLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
        btnLogin.click();
    }

    public void clickBtnRegistrarse() {
        wait.until(ExpectedConditions.elementToBeClickable(btnRegistrarse));
        btnRegistrarse.click();
    }

    public void clickBtnLoginSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(btnLoginSubmit));
        btnLoginSubmit.click();
    }

    public void clickBtnRegistrarToma() {
        wait.until(ExpectedConditions.elementToBeClickable(btnRegistrarToma));
        btnRegistrarToma.click();
    }

    public boolean isVisibleLabelPanelControl() {
        wait.until(ExpectedConditions.visibilityOf(labelPanelControl));
        return labelPanelControl.isDisplayed();
    }

    public boolean isVisibleLabelHistorial() {
        wait.until(ExpectedConditions.visibilityOf(labelHistorial));
        return labelHistorial.isDisplayed();
    }
    public void sendKeysToEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(inputEmail));
        inputEmail.click();
        inputEmail.sendKeys(email);
    }

    public void sendKeysToRutRegistro(String rut) {
        wait.until(ExpectedConditions.visibilityOf(inputRutRegistro));
        inputRutRegistro.click();
        inputRutRegistro.sendKeys(rut);
    }

    public void sendKeysToNombreRegistro(String nombre) {
        wait.until(ExpectedConditions.visibilityOf(inputNombreRegistro));
        inputNombreRegistro.click();
        inputNombreRegistro.sendKeys(nombre);
    }

    public void sendKeysToApellidoRegistro(String apellido) {
        wait.until(ExpectedConditions.visibilityOf(inputApellidoRegistro));
        inputApellidoRegistro.click();
        inputApellidoRegistro.sendKeys(apellido);
    }

    public void sendKeysToEmailRegistro(String email) {
        wait.until(ExpectedConditions.visibilityOf(inputEmailRegistro));
        inputEmailRegistro.click();
        inputEmailRegistro.sendKeys(email);
    }

    public void sendKeysToPasswordRegistro(String password) {
        wait.until(ExpectedConditions.visibilityOf(inputPasswordRegistro));
        inputPasswordRegistro.click();
        inputPasswordRegistro.sendKeys(password);
    }

    public void sendKeysEstaturaRegistro(String estatura) {
        wait.until(ExpectedConditions.visibilityOf(inputEstatura));
        inputEstatura.click();
        inputEstatura.sendKeys(estatura);
    }

    public void sendKeysPeso(String peso) {
        wait.until(ExpectedConditions.visibilityOf(inputPeso));
        inputPeso.click();
        inputPeso.sendKeys(peso);
    }

    public void sendKeysNombreCompletoEmergencia(String nombreCompleto) {
        wait.until(ExpectedConditions.visibilityOf(inputNombreCompletoEmergencia));
        inputNombreCompletoEmergencia.click();
        inputNombreCompletoEmergencia.sendKeys(nombreCompleto);
    }

    public void selectTipoSangre(String tipoSangre) {
        wait.until(ExpectedConditions.visibilityOf(cbxTipoSangre));
        cbxTipoSangre.click();
        cbxTipoSangre.sendKeys(tipoSangre);
    }

    public void sendKeysToFonoEmergencia(String fonoEmergencia) {
        wait.until(ExpectedConditions.visibilityOf(inputFonoEmergencia));
        inputFonoEmergencia.click();
        inputFonoEmergencia.sendKeys(fonoEmergencia);
    }

    public void sendKeysAlergias(String alergias) {
        wait.until(ExpectedConditions.visibilityOf(inputAlergias));
        inputAlergias.click();
        inputAlergias.sendKeys(alergias);
    }

    public void sendKeysInputEnfermedadesCronicas(String enfermedades) {
        wait.until(ExpectedConditions.visibilityOf(inputEnfermadadesCronicas));
        inputEnfermadadesCronicas.click();
        inputEnfermadadesCronicas.sendKeys(enfermedades);
    }

    public void sendKeysToPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(inputPassword));
        inputPassword.click();
        inputPassword.sendKeys(password);
    }

    public void sendKeysToGlucosa(String glucosa) {
        wait.until(ExpectedConditions.visibilityOf(inputGlucosa));
        inputGlucosa.click();
        inputGlucosa.sendKeys(glucosa);
    }

    public void sendKeysToPresionSistolica(String sistolica) {
        wait.until(ExpectedConditions.visibilityOf(inputPresionSistolica));
        inputPresionSistolica.click();
        inputPresionSistolica.sendKeys(sistolica);
    }

    public void sendKeysToPresionDiastolica(String diastolica) {
        wait.until(ExpectedConditions.visibilityOf(inputPresionDiastolica));
        inputPresionDiastolica.click();
        inputPresionDiastolica.sendKeys(diastolica);
    }

    public void clickBtnGuardarRegistro() {
        wait.until(ExpectedConditions.elementToBeClickable(btnGuardarRegistro));
        btnGuardarRegistro.click();
    }

    public void clickAlertRegistro(){
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alerta = driver.switchTo().alert();
            System.out.println("Alerta detectada: " + alerta.getText());
            alerta.accept();
        } catch (Exception e) {
            System.out.println("No apareció ninguna alerta o ya fue manejada.");
        }
    }

    public void clickBtnHistorial() {
        wait.until(ExpectedConditions.elementToBeClickable(btnHistorial));
        btnHistorial.click();
    }

    public boolean isVisibleRegistroConDatos(String glucosa, String presionSistolica, String presionDiastolica) {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(listaRegistros));
            for (WebElement tarjeta : listaRegistros) {
                String textoTarjeta = tarjeta.getText();
                if (textoTarjeta.contains(glucosa) &&
                        textoTarjeta.contains(presionSistolica) &&
                        textoTarjeta.contains(presionDiastolica)) {
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public void clickBtnDescargarPDF(){
        wait.until(ExpectedConditions.elementToBeClickable(btnDescargaPdf));
        btnDescargaPdf.click();
    }

    public void clickBtnContinuarRegistro() {
        wait.until(ExpectedConditions.elementToBeClickable(btnContinuarRegistro));
        btnContinuarRegistro.click();
    }

    public void clickChkDataProcessingConsent() {
        wait.until(ExpectedConditions.elementToBeClickable(chkDataProcessingConsent));
        chkDataProcessingConsent.click();
    }

    public void clickBtnGuardarFichaMedica() {
        wait.until(ExpectedConditions.elementToBeClickable(btnGuardarFichaMedica));
        btnGuardarFichaMedica.click();
    }

    public void limpiarCarpetaDescargas() {
        File carpeta = new File(Hooks.downloadPath);
        File[] archivos = carpeta.listFiles();
        if (archivos != null) {
            for (File archivo : archivos) {
                archivo.delete();
            }
        }
    }

    public boolean isPDFDownloaded(String extension) {
        File carpeta = new File(Hooks.downloadPath);
        int tiempoEspera = 0;
        while (tiempoEspera < 10) {
            File[] listaArchivos = carpeta.listFiles();
            if (listaArchivos != null) {
                for (File archivo : listaArchivos) {
                    if (archivo.getName().endsWith(extension) && !archivo.getName().endsWith(".crdownload")) {
                        return true;
                    }
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tiempoEspera++;
        }
        return false;
    }
}