package i.ua.autotest;

import org.openqa.selenium.By;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/user/IdeaProjects/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://mail.i.ua/");
    }
    @Test
    public void userLogin() {
        WebElement loginField = driver.findElement(By.name("login"));
        loginField.sendKeys("irchikignatieva");
        WebElement passwordField = driver.findElement(By.name("pass"));
        passwordField.sendKeys("U5XTaLskdIH");
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Войти']"));
        loginButton.click();
        WebElement profileUser = driver.findElement(By.className("user_name"));
        String UserName = profileUser.getText();
        Assert.assertEquals("Irina", UserName);
    }
    @AfterClass
    public static void tearDown()
    {
        WebElement menuUser = driver.findElement(By.className("ho_logo"));
        menuUser.click();
        WebElement logoutButton = driver.findElement(By.linkText("Выход"));
        logoutButton.click();
        driver.quit();
    }
}


