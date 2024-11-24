package com.demowebshop.tests;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver=new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod (enabled=false)
    public void tearDown(){
        driver.quit();
    }

    public boolean isHomeComponentPresent(){
        return driver.findElements(By.xpath(" //h2[contains(text(),'Welcome to our store')]")).size()>0;
    }

    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isContinueButtonPresent() {
        return isElementPresent(By.cssSelector(".button-1.register-continue-button"));
    }

    public boolean isErrorMessagePresent() {
        return isElementPresent(By.xpath("//li[text()='The specified email already exists']"));
    }

    protected void fillRegistrationForm(User user) {
        type(By.name("FirstName"), user.getFirstName());
        type(By.name("LastName"), user.getLastName());
        type(By.name("Email"), user.getEmail());
        type(By.name("Password"), user.getPassword());
        type(By.name("ConfirmPassword"), user.getConfirmPassword());
    }

    public void clickOnRegistrationLink() {
        click(By.cssSelector("[href='/register']"));
    }

    public boolean isLogOutButtonPresent() {
        return isElementPresent(By.cssSelector("[href='/logout']"));
    }

    public void clickOnLoginButton() {
        click(By.cssSelector(".button-1.login-button"));
    }


    public void fillLoginForm(User user) {
        type(By.name("Email"),user.getEmail());
        type(By.name("Password"), user.getPassword());
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public void clickOnRegistrationButton() {
        click(By.name("register-button"));
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickOnShoppingCartLink() {
        click(By.cssSelector("a[href='/cart']"));
    }

    public void clickOnAddToCartButton() {
        click(By.cssSelector("input[onclick*='/addproducttocart/catalog/31/']"));
    }

    public void clickOnUpdateShoppingCartButton() {
        click(By.cssSelector("input.button-2.update-cart-button"));
    }

    protected void clickOnRemoveFromCartCheckbox() {
        WebElement checkbox = driver.findElement(By.cssSelector("input[name='removefromcart']"));
        checkbox.click();
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }
}