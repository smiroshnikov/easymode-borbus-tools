package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests {

    @Test
    public void loginTest() {


        System.out.println(OSUtils.os);
        OSUtils.setDriverResources();

        // scenario
        // initialize driver
        // open page
        // user credentials
        // press login
        // verification (new url , log out visible , login message
        //System.setProperty("webdriver.chrome.driver", "/Users/krojiktheloved/IdeaProjects/easymode-borbus-tools/src\\main\\resources\\chromedriver");
//        System.setProperty("webdriver.chrome.driver", "/Users/krojiktheloved/IdeaProjects/easymode-borbus-tools/src/main/resources/chromedriver");
        //System.setProperty("webdriver.chrome.driver", "/src/main/resources/chromedriver");


        ChromeDriver driver = new ChromeDriver();
        System.out.println("Driver Initialized");
//        stayAWhileAndListen(3);
        System.out.println("Starting test ....");
//        driver.manage().window().maximize();
        String URL = "http://the-internet.herokuapp.com/login";
        driver.get(URL);
//        stayAWhileAndListen(5);
        System.out.println("Page is opened ");
        WebElement uname = driver.findElementByXPath("//input[@id='username']");
        uname.sendKeys("tomsmith");
        WebElement psswrd = driver.findElement(By.xpath("//input[@id='password']"));
        psswrd.sendKeys("SuperSecretPassword!");
        WebElement logInButton = driver.findElement(By.className("radius"));
        logInButton.click();
        WebElement logOutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
        String expectedURL = "http://the-internet.herokuapp.com/secure 1";
        String actualURL = driver.getCurrentUrl();
        try {
            Assert.assertEquals(actualURL, expectedURL);
        } catch (AssertionError ae) {
            ae.printStackTrace();
        }
        WebElement successMessage = driver.findElement(By.id("flash"));
        try {
            Assert.assertFalse(successMessage.isDisplayed());
        } catch (AssertionError ae) {
            ae.printStackTrace();
        }
        logOutButton.click();
        driver.quit();
    }

    //ctrl + alt + m - extract method

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
