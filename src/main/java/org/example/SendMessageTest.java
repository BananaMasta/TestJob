package org.example;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.io.IOException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collection;


public class SendMessageTest {
    private static WebDriver driver;

    private static MainPage chromePage;

    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{};
        return Arrays.asList(data);
    }

    @BeforeClass
    public static void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*","--disable-web-security", "--allow-running-insecure-content");
        System.setProperty("webdriver.chrome.driver", "C:/Users/Chucho/Desktop/chrome/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.of(10, ChronoUnit.SECONDS));
        driver.get("https://e.mail.ru/inbox/?app_id_mytracker=58519&authid=lpctn6or.0jb&back=1%2C1&dwhsplit=s10273.b1ss12743s&from=login%2Cnavi&x-login-auth=1&afterReload=1");
        chromePage = new MainPage(driver);
    }
    @Test
    public void orderChrome() throws IOException {
        chromePage.sendMessage();
    }
}
