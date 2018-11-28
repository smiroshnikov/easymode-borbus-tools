package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class PositiveTests {

    static WebDriver driver;
    static private boolean TESTFLAG = false;

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
    public void loginTest() {
        stayAWhileAndListen(3);
        System.out.println("Starting test ....");
        driver.manage().window().maximize();
        String URL = "http://the-internet.herokuapp.com/login";
        driver.get(URL);
        stayAWhileAndListen(5);
        System.out.println("Page is opened ");

        WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
        userName.sendKeys("tomsmith");
        WebElement userPassword = driver.findElement(By.xpath("//input[@id='password']"));
        userPassword.sendKeys("SuperSecretPassword!");
        WebElement logInButton = driver.findElement(By.className("radius"));
        logInButton.click();
        WebElement logOutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));

        String expectedURL = "http://the-internet.herokuapp.com/secure";
        String actualURL = driver.getCurrentUrl();

//        try {
            Assert.assertEquals(actualURL, expectedURL);
//        } catch (AssertionError ae) {
//            ae.printStackTrace();
//        }


        WebElement successMessage = driver.findElement(By.id("flash"));
        Assert.assertFalse(successMessage.isDisplayed());
        //TODO read NotesToRemember #3

        logOutButton.click();

    }


    /**
     * static sleep
     *
     * @param millis amount of milliseconds to sleep
     */
    private void stayAWhileAndListen(long millis) {
        try {
            Thread.sleep(millis);
            // bad practice , 4 stars
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
