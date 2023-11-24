package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {
    private WebDriver driver;
    @FindBy(xpath = "/html/body/main/div[2]/div[2]/div[2]/div/div[1]/button")
    private WebElement enterButton;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/div/div/form/div[2]/div[2]/div[1]/div/div/div/div/div/div[1]/div/input")
    private WebElement mailField;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/div/div/form/div[2]/div[2]/div[3]/div/div/div[1]/button")
    private WebElement passwordButton;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/div/div/form/div[2]/div/div[2]/div/div/div/div/div/input")
    private WebElement passwordField;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/div/div/form/div[2]/div/div[3]/div/div/div[1]/div/button")
    private WebElement enter;
    @FindBy(xpath = "/html/body/div[2]/div/div[5]/div/div/div/div/div/div/div/div/div/div/div/div/div/div[6]/div[1]/div/div[1]/div/div/div/div[2]/div/a")
    private WebElement writeMessageButton;
    @FindBy(xpath = "/html/body/div[2]/div/div[5]/div/div/div/div/div/div/div/div/div/div/div/div/div/div[6]/div[3]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div[1]/div/div/div[2]/div/div/div/textarea[2]")
    private WebElement letterTo;

    @FindBy(xpath = "/html/body/div[2]/div/div[5]/div/div/div/div/div/div/div/div/div/div/div/div/div/div[6]/div[3]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div[4]/div/div/div[2]/div/input")
    private WebElement letterTheme;
    @FindBy(xpath = "/html/body/div[2]/div/div[5]/div/div/div/div/div/div/div/div/div/div/div/div/div/div[6]/div[3]/div[2]/div[2]/div/div/form/div[5]/div[2]/table/tbody/tr/td[1]/div[3]/div[1]/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/span/table/tbody/tr/td/iframe")
    private WebElement letter;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void sendMessage(String myMail, String password, String mailTo) {
        mailField.sendKeys(myMail);
        passwordButton.click();
        passwordField.sendKeys(password);
        enter.click();
        writeMessageButton.click();
        letterTo.sendKeys(mailTo);
        letterTheme.sendKeys("Я сделал домашнее задание, простите за задержку");
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        WebElement editor = driver.findElement(By.id("tinymce"));
        editor.clear();
        editor.sendKeys("Отправляю вам тестовое задание, закину его на гит хаб");
        driver.switchTo().defaultContent();
    }

}
