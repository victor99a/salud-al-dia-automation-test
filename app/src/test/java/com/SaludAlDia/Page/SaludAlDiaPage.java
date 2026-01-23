package com.SaludAlDia.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

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

    public SaludAlDiaPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Espera máx 10 seg
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

    public void clickBtnHistorial() {
        wait.until(ExpectedConditions.elementToBeClickable(btnHistorial));
        btnHistorial.click();
    }
}
