package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class PositiveTests {

    static WebDriver driver;
    static private String URL = "http://the-internet.herokuapp.com/login";

    @BeforeTest
    public static void setUp() {
        System.out.println(OSUtils.os);
        OSUtils.setDriverResources();
        driver = new ChromeDriver();
        System.out.println("Driver Initialized");

    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }


    @Test
    public void CreateAccount() {
        sdccLogin("twister@example.com","******");
        clickOnAdminMenu();
        gotoAccountScreen();


    }

    public void sdccLogin(String username, String password) {
        driver.get("http://10.20.4.167/login");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.className("btnLogin")).click();
        driver.manage().window().maximize();
    }
    public void clickOnAdminMenu() {
        driver.findElement(By.xpath("//div[@sdcc_auto='main_menu']")).click();
    }
    public void gotoAccountScreen() {
        driver.findElement(By.xpath("//a[@sdcc_auto='main_menu_portal_admin']")).click();
    }

    @Test
    public void loginTest() {

        driver.manage().window().maximize();
        driver.get(URL);


        WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
        userName.sendKeys("tomsmith");
        WebElement userPassword = driver.findElement(By.xpath("//input[@id='password']"));
        userPassword.sendKeys("SuperSecretPassword!");
        WebElement logInButton = driver.findElement(By.className("radius"));
        logInButton.click();
        WebElement logOutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));

        String expectedURL = "http://the-internet.herokuapp.com/secure";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
        WebElement successMessage = driver.findElement(By.id("flash"));
        Assert.assertTrue(successMessage.isDisplayed());
        //TODO read NotesToRemember #3

        logOutButton.click();

    }
}
