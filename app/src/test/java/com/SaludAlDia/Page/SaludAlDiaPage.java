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

    public SaludAlDiaPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickBtnLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
        btnLogin.click();
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